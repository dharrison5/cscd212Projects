package cscd212classes.lifeform;

/**
 * The LifeForm class represents a generic life form.
 * It provides basic functionality for managing life points and name of the life form.
 */
public abstract class LifeForm {

    /** The current life points of the life form. */
    protected int currentLifePoints;

    /** The maximum life points of the life form. */
    protected final int MAX_LIFE_POINTS;

    /** The name of the life form. */
    private String name;

    /**
     * Constructs a new LifeForm object
     * @param name The name of the life form.
     * @param currentLifePoints The current life points of the life form.
     * @throws IllegalArgumentException if name is null or empty, or if currentLifePoints is less than or equal to 0.
     */
    public LifeForm(String name, int currentLifePoints){

        if(name == null || name.isEmpty() || currentLifePoints <= 0)
            throw new IllegalArgumentException("bad params LifeForm 2 arg version");

        this.name = name;
        this.currentLifePoints = currentLifePoints;
        this.MAX_LIFE_POINTS = 100;
    }

    /**
     * Constructs a new LifeForm object
     * @param name The name of the life form.
     * @param currentLifePoints The current life points of the life form.
     * @param maxLifePoints The maximum life points of the life form.
     * @throws IllegalArgumentException if name is null or empty, if current or max life points are less than 0,
     * or if current is above max life points
     */
    public LifeForm(String name, int currentLifePoints, int maxLifePoints){

        if(name == null ||
                name.isEmpty() ||
                currentLifePoints <= 0 ||
                maxLifePoints <= 0 ||
                currentLifePoints > maxLifePoints)
            throw new IllegalArgumentException("bad params LifeForm 3 arg version");

        this.name = name;
        this.currentLifePoints = currentLifePoints;
        this.MAX_LIFE_POINTS = maxLifePoints;
    }

    /**
     * Retrieves the current life points of the life form.
     * @return The current life points.
     */
    public int getLifePoints(){return currentLifePoints;}

    /**
     * Retrieves the name of the life form.
     * @return The name of the life form.
     */
    public String getName(){return this.name;}

    /**
     * Reduces the life points of the life form by the specified amount of damage.
     * sets life points to minimum of 0
     * @param damage The amount of damage to be taken.
     * @throws IllegalArgumentException if damage is 0 or less.
     */
    public void takeHit(int damage){

        if(damage <= 0)
            throw new IllegalArgumentException("invalid damage (0 or less) in takeHit");

        if(damage >= currentLifePoints)
            currentLifePoints = 0;
        else
            currentLifePoints -= damage;

    }

    /**
     * gets short sentence of name and life points
     * @return String with descriptive sentence
     */
    @Override
    public String toString(){return name + " has " + currentLifePoints + " life points";}


}
