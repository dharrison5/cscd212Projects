package cscd212classes.behavior;

import cscd212interfaces.alienknowledge.AlienBehavior;
import java.math.*;

/**
 * The UpArmorPercentage class is an armor upgrade between 0% and 100%.
 * It implements the AlienBehavior interface.
 */
public class UpArmorPercentage implements AlienBehavior {

    /**
     * Constructs a new UpArmorPercentage object.
     */
    public UpArmorPercentage(){

    }

    /**
     * Upgrades the armor of the human.
     * Increases armor between 0% and 100% randomly.
     * @return random double between 0 and 1.
     */
    public double upArmor(){

        return (1 + Math.random() * 99) / 100;

    }
}
