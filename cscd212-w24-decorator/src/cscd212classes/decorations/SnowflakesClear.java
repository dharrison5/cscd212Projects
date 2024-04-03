package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class SnowflakesClear extends HolidayItemDecorator{
    /**
     * Constructor for the SnowflakesClear decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public SnowflakesClear(HolidayItem item, double cost){
        super(item, "clear snowflakes", cost);
    }

}
