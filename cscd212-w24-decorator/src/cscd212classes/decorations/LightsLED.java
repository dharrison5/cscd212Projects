package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class LightsLED extends HolidayItemDecorator{
    /**
     * Constructor for the LightsLED decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public LightsLED(HolidayItem item, double cost){
        super(item, "LED lights", cost);
    }

}
