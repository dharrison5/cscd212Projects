package ticketing.classes;

import java.util.ArrayList;
/**
 * A class to represent a reservation of tickets
 */
public class Reservation {
    /** The list of tickets */
    private ArrayList<Ticket> tickets = new ArrayList<>();
    /**
     * Adds a ticket to the reservation
     * @param ticket the ticket to add
     */
    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    /**
     * Overridden toString for reservation
     * @return a string representation of all the tickets in the reservation
     */
    @Override
    public String toString(){
        String s = "";
        for(Ticket ticket : tickets){
            s += ticket;
            s+= "\n\n";
        }
        return s;
    }
}
