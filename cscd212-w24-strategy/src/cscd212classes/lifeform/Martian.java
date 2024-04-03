package cscd212classes.lifeform;

import cscd212interfaces.recovery.RecoveryBehavior;

/**
 * The Martian class represents a type of alien called Martian.
 * It extends the Alien class.
 */
public class Martian extends Alien{

    /**
     * Constructs a new Martian object.
     * @param name The name of the Martian.
     * @param currentLifePoints The current life points of the Martian.
     */
    public Martian(String name, int currentLifePoints){
        super(name, currentLifePoints);
    }

    /**
     * Constructs a new Martian object with all possible parameters.
     * @param name The name of the Martian.
     * @param currentLifePoints The current life points of the Martian.
     * @param maxLifePoints The maximum life points of the Martian.
     * @param recovery The recovery behavior of the Martian.
     */
    public Martian(String name,
                   int currentLifePoints,
                   int maxLifePoints,
                   RecoveryBehavior recovery){
        super(name, currentLifePoints, maxLifePoints, recovery);
    }
}
