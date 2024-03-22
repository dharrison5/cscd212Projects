package ticketing.decorator;

/**
 * TicketDecoratorItem superclass for making ticket decorators
 */
public abstract class TicketDecoratorItem implements TicketDecorator{
    /** the internal ticketDecorator */
    private TicketDecorator ticketDecorator;

    /** the cost of the ticket */
    int cost = 0;

    /** the description of the ticket */
    protected String description;

    /**
     * does nothing in this class, to be used by the builder
     * @param ticketDecorator the ticketDecorator to decorate with
     */
    public void decorate(TicketDecorator ticketDecorator) {
    // this should only be called by TicketBuilder
    }

    /**
     * Set the internal ticketDecorator
     * @param ticketDecorator the ticketDecorator to set
     */
    public void setTicketDecorator(TicketDecorator ticketDecorator){
        if(ticketDecorator == null)
            throw new IllegalArgumentException("Invalid ticketDecoratorItem TicketDecorator setTicketDecorator");

        this.ticketDecorator = ticketDecorator;
    }

    /**
     * Get the cost of the ticket, recursive down to the builder
     * @return the cost of the ticket
     */
    public int getCost(){
        return this.cost + ticketDecorator.getCost();
    }

    /**
     * Get the description of the ticket, recursive down to the builder
     * @return the description of the ticket
     */
    public String getDescription(){
        return ticketDecorator.getDescription()  + this.description + ", ";
    }
}
