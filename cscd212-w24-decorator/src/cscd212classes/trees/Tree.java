package cscd212classes.trees;

import cscd212interfaces.HolidayItem;

public abstract class Tree implements HolidayItem {
    /** price of the item */
    protected double cost;
    /** name of the tree */
    private String treeType;

    /**
     * Constructor for the abstract tree class
     * @param treeType the name of the tree, decided by the subclass
     * @param cost price of the tree
     */
    public Tree(String treeType, double cost){
        if(treeType == null || cost < 0)
            throw new IllegalArgumentException("invalid params Tree");

        this.treeType = treeType;
        this.cost = cost;
    }

    /**
     * basic getter for the price of the tree
     * @return price of the tree
     */
    public double getCost(){
        return cost;
    }

    /**
     * final part of description call, begins the description of the objects
     * @return name of the tree + "with, "
     */
    public String getDescription(){
        return this + "with ";
    }

    /**
     * Overridden toString for the Tree class
     * @return "My tree is a " and the type of tree
     */
    @Override
    public String toString(){
        return "My tree is a " + treeType;
    }
}
