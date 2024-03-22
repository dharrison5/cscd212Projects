package ticketing.decorator;

/**
 * TicketDecorator interface for getting costs and descriptions of tickets
 */
public interface TicketDecorator {

    /**
     * Get the cost of the ticket
     * @return the cost of the ticket
     */
    public int getCost();

    /**
     * Get the description of the ticket
     * @return the description of the ticket
     */
    public String getDescription();

    /**
     * Decorate the ticket
     * @param ticketDecorator the ticketDecorator to decorate with
     */
    public void decorate(TicketDecorator ticketDecorator);

    /**
     * Set the ticketDecorator
     * @param ticketDecorator the ticketDecorator to set
     */
    public void setTicketDecorator(TicketDecorator ticketDecorator);

}
