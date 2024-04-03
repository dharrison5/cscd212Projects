package cscd212classes.lifeform;

import cscd212interfaces.alienknowledge.AlienBehavior;

/**
 * The Human class represents a human , it extends the LifeForm class.
 * It includes functionality for managing armor points and taking damage.
 */
public class Human extends LifeForm{

    /** The armor points of the human. */
    private int armorPoints;

    /** The behavior of the human regarding aliens. */
    private AlienBehavior behavior;

    /**
     * Constructs a new Human object with all possible parameters.
     * @param name The name of the human.
     * @param currentLifePoints The current life points of the human.
     * @param maxLifePoints The maximum life points of the human.
     * @param armorPoints The armor points of the human.
     * @param behavior The behavior of the human regarding aliens.
     * @throws IllegalArgumentException if armorPoints is negative.
     */
    public Human(String name,
                 int currentLifePoints,
                 int maxLifePoints,
                 int armorPoints,
                 AlienBehavior behavior){

        super(name, currentLifePoints, maxLifePoints);

        if(armorPoints < 0) {
            throw new IllegalArgumentException("Invalid armor value Human");
        }

        this.armorPoints = armorPoints;
        this.behavior = behavior;

    }

    /**
     * Constructs a new Human object.
     * Initializes armor points based on the behavior.
     * @param name The name of the human.
     * @param currentLifePoints The current life points of the human.
     * @param behavior The behavior of the human regarding aliens.
     */
    public Human(String name, int currentLifePoints, AlienBehavior behavior){

        super(name, currentLifePoints);
        this.behavior = behavior;
        armorPoints = 100 + (int)(100 * behavior.upArmor());

    }

    /**
     * Retrieves the armor points of the human.
     * @return The armor points.
     */
    public int getArmorPoints(){return armorPoints;}

    /**
     * Sets the armor points of the human depending on the behavior.
     * @param armorPoints The new armor points value.
     * @throws IllegalArgumentException if armorPoints is negative.
     */
    public void setArmorPoints(int armorPoints){

        if(armorPoints < 0)
            throw new IllegalArgumentException("invalid armorPoints in setArmorPoints");

        this.armorPoints = armorPoints + (int)(armorPoints * behavior.upArmor());
    }

    /**
     * Sets the alien behavior of the human.
     * @param behavior The new alien behavior.
     * @throws IllegalArgumentException if behavior is null.
     */
    public void setAlienBehavior(AlienBehavior behavior){

        if(behavior == null)
            throw new IllegalArgumentException("null behavior in setAlienBehavior");

        this.behavior = behavior;
    }

    /**
     * Generates a descriptive sentence of the human, including armor points.
     * @return A descriptive sentence of the human.
     */
    @Override
    public String toString(){
        return super.toString() + " and " + armorPoints + " armor points";
    }

    /**
     * Reduces the life points of the human when taking damage,
     * damage will hit armor first, then life points.
     * @param damage The amount of damage to be taken.
     * @throws IllegalArgumentException if damage is 0 or less.
     */
    @Override
    public void takeHit(int damage){
        if(damage <= 0)
            throw new IllegalArgumentException("invalid damage in Human takeHit");

        if(damage > armorPoints) {
            super.takeHit(damage - armorPoints);
            armorPoints = 0;
        }
        else
            armorPoints -= damage;
    }


}
