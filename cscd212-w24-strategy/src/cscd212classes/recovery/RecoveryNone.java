package cscd212classes.recovery;

import cscd212interfaces.recovery.RecoveryBehavior;

/**
 * The RecoveryLinear class represents no recovery.
 * It implements the RecoveryBehavior interface.
 */
public class RecoveryNone implements RecoveryBehavior {

    /**
     * Constructs a new RecoveryNone object.
     */
    public RecoveryNone(){}

    /**
     * as the RecoveryNone behavior does nothing, returns 0
     * the host life form can not recover life points.
     * @return 0
     */
    @Override
    public int calculateRecovery(int currentLifePoints) {
        return 0;
    }
}
