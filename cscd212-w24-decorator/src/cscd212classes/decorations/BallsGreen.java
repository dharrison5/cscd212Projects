package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class BallsGreen extends HolidayItemDecorator{

    /**
     * Constructor for the BallsGreen decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public BallsGreen(HolidayItem item, double cost){
        super(item, "green balls", cost);
    }

}
