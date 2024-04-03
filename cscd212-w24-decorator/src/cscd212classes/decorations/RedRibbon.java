package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class RedRibbon extends HolidayItemDecorator{
    /**
     * Constructor for the RedRibbon decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public RedRibbon(HolidayItem item, double cost){
        super(item, "a red ribbon", cost);
    }

}
