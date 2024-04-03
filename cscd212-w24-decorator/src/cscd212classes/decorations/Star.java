package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class Star extends HolidayItemDecorator{
    /**
     * Constructor for the Star decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public Star(HolidayItem item, double cost){
        super(item, "a star", cost);
    }


}
