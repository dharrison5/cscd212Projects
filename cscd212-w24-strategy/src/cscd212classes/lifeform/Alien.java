package cscd212classes.lifeform;

import cscd212classes.recovery.RecoveryNone;
import cscd212interfaces.recovery.RecoveryBehavior;

/**
 * The Alien class represents an alien life form, extending the LifeForm class.
 * It includes functionality for managing recovery behavior.
 */
public class Alien extends LifeForm{

    /** The recovery behavior of the alien. */
    private RecoveryBehavior recovery;

    /**
     * Constructs a new Alien object.
     * @param name The name of the alien.
     * @param currentLifePoints The current life points of the alien.
     * @param maxLifePoints The maximum life points of the alien.
     * @param recovery The recovery behavior of the alien.
     * @throws IllegalArgumentException if recovery is null.
     */
    public Alien(String name,
                 int currentLifePoints,
                 int maxLifePoints,
                 RecoveryBehavior recovery){

        super(name, currentLifePoints, maxLifePoints);

        if(recovery == null)
            throw new IllegalArgumentException("invalid recovery Alien");

        this.recovery = recovery;

    }

    /**
     * Constructs a new Alien object.
     * Initializes recovery behavior to None, uses LifeForms default max life points.
     * @param name The name of the alien.
     * @param currentLifePoints The current life points of the alien.
     */
    public Alien(String name, int currentLifePoints){
        super(name, currentLifePoints);
        this.recovery = new RecoveryNone();
    }

    /**
     * Sets the current life points of the alien.
     * @param currentLifePoints The new current life points value.
     * @throws IllegalArgumentException if currentLifePoints is 0 or less, or exceeds max life points.
     */
    public void setCurrentLifePoints(int currentLifePoints){
        if(currentLifePoints <= 0 || currentLifePoints > MAX_LIFE_POINTS)
            throw new IllegalArgumentException("invalid currentLifePoints setCurretLifePoints Alien");

        this.currentLifePoints = currentLifePoints;
    }

    /**
     * Sets the recovery behavior of the alien.
     * @param newRecovery The new recovery behavior.
     * @throws IllegalArgumentException if newRecovery is null.
     */
    public void setRecoveryBehavior(RecoveryBehavior newRecovery){
        if(newRecovery == null)
            throw new IllegalArgumentException("null newRecovery setRecoveryBehavior Alien");

        this.recovery = newRecovery;
    }

    /**
     * Retrieves the recovery behavior of the alien.
     * @return The recovery behavior.
     */
    public RecoveryBehavior getRecoveryBehavior(){return this.recovery;}

    /**
     * Initiates the health of the alien depending on the recovery behavior
     * @return A string indicating the amount of recovery points gained.
     */
    public String recover(){
        int toRecover = recovery.calculateRecovery(currentLifePoints);

        if(toRecover + currentLifePoints > MAX_LIFE_POINTS)
            toRecover = MAX_LIFE_POINTS - currentLifePoints;

        currentLifePoints += toRecover;

        return getName() + " has had " + toRecover + " recovery points added to their current life points";
    }

    /**
     * Generates a string representation of the alien, including its name, current life points, and recovery mode.
     * @return A descriptive sentence of the alien.
     */
    @Override
    public String toString(){
        return super.toString() + " and has recovery mode of " + recovery.getClass().getSimpleName();
    }
}
