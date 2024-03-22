package ticketing.planes;

import ticketing.flyBehavior.FlyBehavior;

/**
 * abstract superclass for all planes
 */
public abstract class Plane {

    /** name of the plane */
    private String name;

    /** capacity of the plane */
    private int capacity;

    /** fly behavior of the plane */
    private FlyBehavior flyBehavior;

    /**
     * Constructor for the Plane class
     * @param name name of the plane
     * @param capacity capacity of the plane
     * @param flyBehavior fly behavior of the plane
     */
    public Plane(String name, int capacity, FlyBehavior flyBehavior){
        if(name == null || name.isBlank() || capacity < 1 || flyBehavior == null)
            throw new IllegalArgumentException("Invalid parameters Plane");

        this.name = name;
        this.capacity = capacity;
        this.flyBehavior = flyBehavior;
    }

    /**
     * returns the fly behavior of the plane
     * @return the fly behavior of the plane
     */
    public FlyBehavior getFlyBehavior(){return flyBehavior;}

    /**
     * prints a sentence based on the fly behavior of the plane
     */
    public void fly(){
        this.flyBehavior.fly();
    }

    /**
     * returns the name of the plane
     * @return the name of the plane
     */
    public String getName(){
        return this.name;
    }

    /**
     * returns the capacity of the plane
     * @return the capacity of the plane
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * sets the fly behavior of the plane
     * @param flyBehavior the fly behavior to set
     */
    public void setFlyBehavior(FlyBehavior flyBehavior){
        if(flyBehavior == null)
            throw new IllegalArgumentException("Invalid flyBehavior Plane setFlyBehavior");

        this.flyBehavior = flyBehavior;
    }

    /**
     * sets the capacity of the plane
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        if(capacity < 1)
            throw new IllegalArgumentException("Invalid capacity Plane setCapacity");
        this.capacity = capacity;
    }

    /**
     * sets the name of the plane
     * @param name the name to set
     */
    public void setName(String name) {
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Invalid name Plane setName");
        this.name = name;
    }
}
