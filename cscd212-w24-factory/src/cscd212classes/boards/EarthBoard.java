package cscd212classes.boards;

import cscd212classes.factories.LifeFormFactory;
import cscd212enums.DifficultyLevel;
import cscd212enums.LifeFormType;

/**
 * EarthBoard class
 */
public class EarthBoard extends GameBoard {

    /**
     * EarthBoard constructor
     * @param difficultyLevel DifficultyLevel
     */
    public EarthBoard(DifficultyLevel difficultyLevel){
        super(difficultyLevel);
    }

    /**
     * Create life forms for the earth board
     */
    protected void createLifeForms(){
        LifeFormType martian = LifeFormType.MARTIAN;
        LifeFormType human = LifeFormType.HUMAN;

        player = LifeFormFactory.getLifeForm(martian);

        enemyLifeForms.add(LifeFormFactory.getLifeForm(human, "Dave", 110));
        enemyLifeForms.add(LifeFormFactory.getLifeForm(human));

    }
}
