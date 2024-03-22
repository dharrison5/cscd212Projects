package ticketing.decorator;

/**
 * FirstClassDecor decorator for adding a first class seat to a ticket
 */
public class FirstClassDecor extends TicketDecoratorItem{

    /**
     * Constructor for FirstClassDecor with preset values
     */
        public FirstClassDecor(){
            this.cost = 120;
            this.description = "A First Class Seat";
        }
}
