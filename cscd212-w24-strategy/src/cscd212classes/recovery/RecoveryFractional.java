package cscd212classes.recovery;

import cscd212interfaces.recovery.RecoveryBehavior;

/**
 * The RecoveryFractional class represents a recovery behavior where a fraction of the current life points is recovered.
 * It implements the RecoveryBehavior interface.
 */
public class RecoveryFractional implements RecoveryBehavior {

    /** The base recovery value is the minimum amount the alien can recover. */
    private final int BASE_RECOVERY;

    /** The percentage of recovery. */
    private double recoveryPercent;

    /**
     * Constructs a new RecoveryFractional object.
     * @param recoveryPercent The percentage of recovery.
     * @param baseRecovery The base recovery value.
     */
    public RecoveryFractional(double recoveryPercent, int baseRecovery){
        this.recoveryPercent = recoveryPercent;
        this.BASE_RECOVERY = baseRecovery;
    }

    /**
     * Constructs a new RecoveryFractional object using 10 base recovery
     * @param recoveryPercent The percentage of recovery.
     */
    public RecoveryFractional(double recoveryPercent){
        this.recoveryPercent = recoveryPercent;
        this.BASE_RECOVERY = 10;
    }

    /**
     * Calculates the amount of recovery based on the current life points and the recovery percentage.
     * Can not return less than the base recovery value.
     * @param currentLifePoints The current life points of the entity.
     * @return The amount of recovery.
     */
    @Override
    public int calculateRecovery(int currentLifePoints){
        int toRecover = (int) (currentLifePoints * (recoveryPercent));
        return Math.max(toRecover, BASE_RECOVERY);
    }
}
