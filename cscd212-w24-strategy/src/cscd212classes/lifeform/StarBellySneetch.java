package cscd212classes.lifeform;

import cscd212interfaces.recovery.RecoveryBehavior;

/**
 * The StarBellySneetch class represents an alien known as the Star-Belly Sneetch.
 * They have stars on their bellies. Reportedly. Nobody has ever seen one and lived.
 * It extends the Alien class.
 */
public class StarBellySneetch extends Alien {

    /**
     * Constructs a new StarBellySneetch object.
     * @param name The name of the StarBellySneetch.
     * @param currentLifePoints The current life points of the StarBellySneetch.
     */
    public StarBellySneetch(String name, int currentLifePoints){
        super(name, currentLifePoints);
    }

    /**
     * Constructs a new StarBellySneetch object with all possible parameters.
     * @param name The name of the StarBellySneetch.
     * @param currentLifePoints The current life points of the StarBellySneetch.
     * @param maxLifePoints The maximum life points of the StarBellySneetch.
     * @param recovery The recovery behavior of the StarBellySneetch.
     */
    public StarBellySneetch(String name,
                            int currentLifePoints,
                            int maxLifePoints,
                            RecoveryBehavior recovery){
        super(name, currentLifePoints, maxLifePoints, recovery);
    }
}
