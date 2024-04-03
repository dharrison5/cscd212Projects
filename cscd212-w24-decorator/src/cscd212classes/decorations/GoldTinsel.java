package cscd212classes.decorations;

import cscd212interfaces.HolidayItem;

public class GoldTinsel extends HolidayItemDecorator{

    /**
     * Constructor for the GoldTinsel decorator
     * @param item inner decorator or tree item
     * @param cost how much this item costs
     */
    public GoldTinsel(HolidayItem item, double cost){
        super(item, "gold tinsel", cost);
    }

}
