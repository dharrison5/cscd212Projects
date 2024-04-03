package cscd212classes.boards;

import cscd212classes.factories.LifeFormFactory;
import cscd212enums.DifficultyLevel;
import cscd212enums.LifeFormType;

/**
 * MarsBoard class
 */
public class MarsBoard extends GameBoard{

    /**
     * MarsBoard constructor
     * @param difficultyLevel DifficultyLevel
     */
    public MarsBoard(DifficultyLevel difficultyLevel) {
        super(difficultyLevel);
    }

    /**
     * Create life forms for the mars board, including enemies and the player
     */
    protected void createLifeForms() {
        LifeFormType human = LifeFormType.HUMAN;
        LifeFormType martian = LifeFormType.MARTIAN;

        player = LifeFormFactory.getLifeForm(human);

        enemyLifeForms.add(LifeFormFactory.getLifeForm(martian));
        enemyLifeForms.add(LifeFormFactory.getLifeForm(martian, "Steve", 50));
        enemyLifeForms.add(LifeFormFactory.getLifeForm(human, "Evil Carl", 110));
        enemyLifeForms.add(LifeFormFactory.getLifeForm(human, "Carl", 100));
    }
}
