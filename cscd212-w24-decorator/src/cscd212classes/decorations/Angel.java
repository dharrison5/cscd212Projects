package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class Angel extends HolidayItemDecorator{

    /**
     * Constructor for the Angel decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public Angel(HolidayItem item, double cost){
        super(item, "an angel", cost);
    }
}
