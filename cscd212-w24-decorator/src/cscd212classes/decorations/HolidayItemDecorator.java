package cscd212classes.decorations;

import cscd212classes.trees.BalsamFir;
import cscd212classes.trees.Tree;
import cscd212interfaces.HolidayItem;

public abstract class HolidayItemDecorator implements HolidayItem {
    /** The double for the decoration cost */
     protected double cost;
    /** The reference to the decoration name */
     protected String name;
    /** The reference to the HolidayItem */
    protected HolidayItem item;

    /**
     * Constructor for HolidayItemDecorator abstract class
     * @param item representing the inner item this is decorating
     * @param name the name of the decoration
     * @param cost the price of the decoration
     */
    public HolidayItemDecorator(HolidayItem item, String name, double cost){
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("invalid name HolidayItemDecorator");

        this.item = item;
        this.name = name;
        this.cost = cost;
    }

    /**
     * recursive call, gets this items cost plus all inner items costs
     * @return price of the all items
     */
    protected double getItemCost(){return item.getCost() + cost;}

    /**
     * basic getter for this items price
     * @return cost of the item
     */
    public double getCost(){return this.getItemCost();}

    /**
     * basic getter for the item's name
     * @return the items name
     */
    protected String getName(){return name;}

    /** gets the description of itself and all inner items
     * it seemed easier to make this a concrete method as it's the same for all
     * subclasses. */
    public String getDescription(){return item.getDescription() + this.getName() + ", ";}
}
