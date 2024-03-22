package ticketing.decorator;

/**
 * CheckedBagDecor class for adding a checked bag to a ticket
 */
public class CheckedBagDecor extends TicketDecoratorItem{

    /**
     * Constructor for CheckedBagDecor with preset values
     */
    public CheckedBagDecor(){
        this.cost = 35;
        this.description = "A Checked Bag";
    }
}
