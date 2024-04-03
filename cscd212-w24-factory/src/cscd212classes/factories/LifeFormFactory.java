package cscd212classes.factories;

import cscd212classes.lifeform.*;
import cscd212enums.LifeFormType;

/**
 * LifeFormFactory class
 */
public class LifeFormFactory {

    /**
     * Get a life form with full parameters
     * @param lifeFormType LifeFormType
     * @param name String
     * @param currentLifePoints int
     * @return LifeForm
     */
    public static LifeForm getLifeForm(LifeFormType lifeFormType, String name, int currentLifePoints) {
        if(name== null || name.isEmpty() || currentLifePoints < 1)
            throw new IllegalArgumentException("Invalid params LifeFormType getLifeForm");

        return switch (lifeFormType) {
            case HALF_ORC -> new HalfOrc(name, currentLifePoints);
            case HUMAN -> new Human(name, currentLifePoints);
            case KRYPTON -> new Kryptonians(name, currentLifePoints);
            case MARTIAN -> new Martian(name, currentLifePoints);
            default -> throw new IllegalArgumentException("Invalid params LifeFormType getLifeForm");
        };

    }

    /**
     * Get a life form with only the type, gives default values for life form
     * @param lifeFormType LifeFormType
     * @return LifeForm
     */
    public static LifeForm getLifeForm(LifeFormType lifeFormType){
        return switch (lifeFormType) {
            case HALF_ORC -> new HalfOrc(lifeFormType.getName(), lifeFormType.getCurrentLifePoints());
            case HUMAN -> new Human(lifeFormType.getName(), lifeFormType.getCurrentLifePoints());
            case KRYPTON -> new Kryptonians(lifeFormType.getName(), lifeFormType.getCurrentLifePoints());
            case MARTIAN -> new Martian(lifeFormType.getName(), lifeFormType.getCurrentLifePoints());
            default -> throw new IllegalArgumentException("Invalid params LifeFormType getLifeForm");
        };
    }
    public LifeFormFactory() {}
}
