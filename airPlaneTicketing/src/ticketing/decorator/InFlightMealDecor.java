package ticketing.decorator;

/**
 * InFlightMealDecor class for making in-flight meal decorators
 */
public class InFlightMealDecor extends TicketDecoratorItem{

    /**
     * Constructor for InFlightMealDecor with preset values
     */
        public InFlightMealDecor(){
            this.cost = 15;
            this.description = "An In-Flight Meal";
        }
}
