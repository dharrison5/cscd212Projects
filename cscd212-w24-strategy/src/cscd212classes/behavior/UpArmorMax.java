package cscd212classes.behavior;

import cscd212interfaces.alienknowledge.AlienBehavior;

/**
 * The UpArmorMax class is an armor upgrade of either 100% or 0% at random
 * It implements the AlienBehavior interface.
 */
public class UpArmorMax implements AlienBehavior {

    /**
     * Constructs a new UpArmorMax object.
     */
    public UpArmorMax(){}

    /**
     * Upgrades the armor of the human.
     * The probability of success is 25%.
     * success doubles the armor, failure does nothing.
     * @return 1 if the armor upgrade is successful, 0 otherwise.
     */
    public double upArmor(){

        double randNum = 1 + Math.random() * 99;

        if(randNum > 75)
            return 1;
        else
            return 0;
    }
}
