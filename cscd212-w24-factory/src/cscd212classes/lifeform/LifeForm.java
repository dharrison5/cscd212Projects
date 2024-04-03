package cscd212classes.lifeform;

/**
 * LifeForm super class
 */
public abstract class LifeForm {

    /** name of the life form */
    private final String name;

    /** current life points of the life form */
    protected int currentLifePoints;

    /**
     * LifeForm constructor
     * @param name String
     * @param currentLifePoints int
     */
    public LifeForm(String name, int currentLifePoints) {
        if(name == null || name.isEmpty() || currentLifePoints <= 0)
            throw new IllegalArgumentException("Invalid parameters LifeForm");
        this.name = name;
        this.currentLifePoints = currentLifePoints;
    }

    /**
     * Get the current life points of the Life form.
     * @return int
     */

    public int getCurrentLifePoints() {
        return this.currentLifePoints;
    }

    /**
     * Set the current life points of the Life form.
     * @param currentLifePoints int
     */
    public void setCurrentLifePoints(int currentLifePoints) {
        if(currentLifePoints < 0)
            throw new IllegalArgumentException("Invalid currentLifePoints LifeForm");
        this.currentLifePoints = currentLifePoints;
    }

    /**
     * Get the name of the Life form.
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Tostring method for the life form, returns the name and current life points.
     * @return String
     */
    public String toString() {
        return name + " has " + currentLifePoints + " life points";
    }
}
