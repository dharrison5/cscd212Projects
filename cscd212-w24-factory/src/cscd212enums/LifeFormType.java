package cscd212enums;

/**
 * BoardTheme enum
 */
public enum LifeFormType {

    HALF_ORC("Gruumsh", 200),
    HUMAN("Hugh Mann", 100),
    KRYPTON("Kal-El", 300),
    MARTIAN("Marvin", 120);

    /**
     * Current life points
     */
    private int currentLifePoints;

    /**
     * Name of the life form
     */
    private String name;

    /**
     * LifeFormType constructor
     * @param name String
     * @param currentLifePoints int
     */
    private LifeFormType(String name, int currentLifePoints) {
        if(name == null || name.isEmpty() || currentLifePoints <= 0)
            throw new IllegalArgumentException("Invalid params LifeFormType");

        this.name = name;
        this.currentLifePoints = currentLifePoints;
    }

    /**
     * get the name of the life form
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * get the current life points of the life form
     * @return int
     */
    public int getCurrentLifePoints() {
        return this.currentLifePoints;
    }
}
