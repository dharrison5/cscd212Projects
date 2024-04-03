package cscd212enums;

/**
 * BoardTheme enum
 */
public enum DifficultyLevel {

    EASY(0.7),
    HARD(1.5),
    INSANE(2),
    NORMAL(1);
    /**
     * Difficulty modifier
     */
    private final double difficultyModifier;

    /**
     * DifficultyLevel constructor
     * @param difficultyModifier double
     */
    private DifficultyLevel(double difficultyModifier) {
        if(difficultyModifier < 0) {
            throw new IllegalArgumentException("Invalid parameter DifficultyLevel");
        }
        this.difficultyModifier = difficultyModifier;
    }

    /**
     * Get the difficulty modifier
     * @return double
     */
    public double getModifier() {
        return this.difficultyModifier;
    }
}
