package ticketing.classes;

import ticketing.airports.Airport;
import ticketing.decorator.TicketDecorator;
import ticketing.planes.Plane;

import java.util.*;

/**
 * the Ticket class. contains all info related to the flight
 */
public class Ticket {
    /** the airports the flight will be flying to*/
    private ArrayList<Airport> airports = new ArrayList<>();

    /** the plane that will be used for the flight*/
    private Plane plane;

    /** the name of the passenger*/
    private String passengerName;

    /** the cost of the ticket*/
    private double cost;

    /** the description of the ticket*/
    private String description;

    /**
     * the constructor for the ticket
     * @param passengerName the name of the passenger
     */
    public Ticket(String passengerName){
        this.passengerName = passengerName;
    }

    /**
     * sets the list of airports
     */
    public void setAirports(ArrayList<Airport> airports) {
        this.airports = airports;
    }


    /**
     * sets the plane
     */
    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    /**
     * sets the passenger name
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * sets the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets the list of airports
     * @return the list of airports
     */
    public ArrayList<Airport> getAirports(){
        return airports;
    }

    /**
     * gets the plane
     * @return the plane
     */
    public Plane getPlane(){
        return plane;
    }

    /**
     * gets the passenger name
     * @return the passenger name
     */
    public String getPassengerName(){
        return passengerName;
    }

    /**
     * gets the cost
     * @return the cost
     */
    public double getCost(){
        return cost;
    }

    /**
     * gets the description
     * @return the description
     */
    @Override
    public String toString(){
        return description;
    }
}
