package cscd212interfaces.recovery;

/**
 * represents an interface that allows host aliens to be assigned different recovery behaviors.
 */
public interface RecoveryBehavior {

    /**
     * overridden method for aliens to increase life points.
     * @return int representing life point increase
     */
    int calculateRecovery(int currentLifePoints);
}
