package cscd212classes.boards;

import cscd212classes.factories.LifeFormFactory;
import cscd212enums.DifficultyLevel;
import cscd212enums.LifeFormType;

/**
 * EarthBoard class
 */
public class FantasyBoard extends GameBoard{

    /**
     * FantasyBoard constructor
     * @param difficultyLevel DifficultyLevel
     */
    public FantasyBoard(DifficultyLevel difficultyLevel){
        super(difficultyLevel);
    }

    /**
     * Create life forms for the fantasy board
     */
    protected void createLifeForms(){
        LifeFormType halforc = LifeFormType.HALF_ORC;
        LifeFormType krypton = LifeFormType.KRYPTON;
        LifeFormType human = LifeFormType.HUMAN;

        player = LifeFormFactory.getLifeForm(halforc);

        enemyLifeForms.add(LifeFormFactory.getLifeForm(krypton));
        enemyLifeForms.add(LifeFormFactory.getLifeForm(krypton, "Uzguk", 80));
        enemyLifeForms.add(LifeFormFactory.getLifeForm(human, "Dave", 110));
    }
}
