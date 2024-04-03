package cscd212classes.recovery;

import cscd212interfaces.recovery.RecoveryBehavior;

/**
 * The RecoveryLinear class represents a fixed recovery amount.
 * It implements the RecoveryBehavior interface.
 */
public class RecoveryLinear implements RecoveryBehavior {

    /** The amount of fixed recovery.*/
    private int recoveryStep;

    /**
     * Constructs a new RecoveryLinear object.
     * @param recoveryStep The amount of recovery per step.
     * @throws IllegalArgumentException if recoveryStep is 0 or less.
     */
    public RecoveryLinear(int recoveryStep){
        if(recoveryStep <= 0)
            throw new IllegalArgumentException("invald recoveryStep RecoveryLinear");

        this.recoveryStep = recoveryStep;
    }

    /**
     * returns the fixed amount indicated by recoveryStep
     * @param currentLifePoints The current life points of the entity.
     * @return The amount of recovery.
     */
    @Override
    public int calculateRecovery(int currentLifePoints){
        return recoveryStep;
    }
}
