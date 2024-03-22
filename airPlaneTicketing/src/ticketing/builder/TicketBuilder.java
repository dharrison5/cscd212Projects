package ticketing.builder;

import ticketing.airports.Airport;
import ticketing.classes.Ticket;
import ticketing.decorator.TicketDecorator;
import ticketing.planes.Plane;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The builder class. The ticket and it's description are all built here
 * and then passed into the ticket once finished
 */
public class TicketBuilder implements TicketDecorator {
    /** the list of airports on the ticket */
    private ArrayList<Airport> airports = new ArrayList<>();
    /** the plane on the ticket */
    private Plane plane;
    /** the passenger name on the ticket */
    private String passengerName;
    /** the ticket being built */
    private Ticket ticket;
    /** the outermost decorator */
    private TicketDecorator ticketDecorator;

    /**
     * Constructor for the ticket builder
     * @param passengerName the passenger name
     */
    public TicketBuilder(String passengerName){
        if(passengerName == null || passengerName.isBlank())
            throw new IllegalArgumentException("Invalid passengerName TicketBuilder");
        this.passengerName = passengerName;
        this.ticketDecorator = this;
    }

    /**
     * resets the ticket builder
     */
    public void reset(){
        airports = new ArrayList<>();
        plane = null;
        passengerName = null;
        ticket = null;
        ticketDecorator = this;
    }

    /**
     * gets the cost of the center ticket, passed to decorator getCost
     * @return the cost of the ticket
     */
    public int getCost(){
        Integer cost = 0;
        for(Airport airport : airports){
            cost += airport.getCost();
        }
        return cost;
    }

    /**
     * returns a list of airports and the total distance between them
     * @return
     */
    private String getFlightPath(){

        String s = "";
        double totalDistance = 0.0;

        for(int i = 0; i < airports.size() - 1; i++){
                s += airports.get(i).getAirportCode() + " to ";
            }
        s += airports.getLast().getAirportCode();

        s += " for a total distance of ";

        for(int i = 1; i < airports.size(); i++){
            // literally just pythagorean theorem for each set of airport coords, proud of this one
            double distance = Math.sqrt(
                            Math.pow(airports.get(i).getCoordinates()[0] - airports.get(i-1).getCoordinates()[0], 2)
                            + Math.pow(airports.get(i).getCoordinates()[1] - airports.get(i-1).getCoordinates()[1], 2));
            totalDistance += distance;
        }

        DecimalFormat df = new DecimalFormat("#.#");
        s += df.format(totalDistance) + " miles";
        return s;
    }
    /**
     * gets the description of the ticket, passed to decorator getDescription
     * @return the description of the ticket
     */
    public String getDescription(){
        return "Ticket for: " + passengerName + "\n Vessel: \t"
                + plane.getName() + "\n From: \t\t"
                + getFlightPath() + "\n For: \t\t$" + getCost()
                + "\n With: \t\t";
    }

    /**
     * gets the plane on the ticket
     * @return the plane on the ticket
     */
    public Plane getPlane(){
        return plane;
    }

    /**
     * gets the list of airports on the ticket
     * @return the list of airports on the ticket
     */
    public ArrayList<Airport> getAirports(){
        return airports;
    }

    /**
     * gets the passenger name on the ticket
     * @return the passenger name on the ticket
     */
    public String getPassengerName(){
        return passengerName;
    }

    /**
     * gets the outermost decorator
     * @return the outermost decorator
     */
    public TicketDecorator getTicketDecorator() {
        return ticketDecorator;
    }

    /**
     * adds another external decorator to the ticket without losing its pointer
     * I melted my brain for a whole day figuring this out. It's 2 lines.
     * @param ticketDecorator the outermost decorator to add
     */
    public void decorate(TicketDecorator ticketDecorator) {
        ticketDecorator.setTicketDecorator(this.ticketDecorator);
        this.ticketDecorator = ticketDecorator;
    }

    /**
     * sets the decorator
     * @param ticketDecorator the outermost decorator to set
     */
    public void setTicketDecorator(TicketDecorator ticketDecorator) {
        this.ticketDecorator = ticketDecorator;
    }

    /**
     * adds an airport to the list
     * @param airport the airport to add
     */
    public void addAirport(Airport airport){
        if(airport == null)
            throw new IllegalArgumentException("Invalid airport TicketBuilder addAirport");
        else if(!airports.isEmpty() && airports.getLast().compareTo(airport) == 0) {
            throw new IllegalArgumentException("Cannot fly to the airport you are already at addAirport");
        }
        airports.add(airport);
    }

    /**
     * sets the plane on the ticket
     * @param plane the plane to set
     */
    public void setPlane(Plane plane){
        if(plane == null)
            throw new IllegalArgumentException("Invalid plane TicketBuilder setPlane");
        this.plane = plane;
    }

    /**
     * gets the final ticket object
     * @return the ticket
     */
    public Ticket getTicket(){
        if(airports.size() < 2 || plane == null)
            throw new IllegalStateException("Invalid airports or plane TicketBuilder getTicket");

        ticket = new Ticket(passengerName);
        ticket.setAirports(airports);
        ticket.setPlane(plane);
        ticket.setCost(ticketDecorator.getCost());
        ticket.setDescription(ticketDecorator.getDescription().substring(0, ticketDecorator.getDescription().length() - 2));
        return ticket;
    }
}
