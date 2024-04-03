package cscd212classes.boards;

import cscd212classes.lifeform.LifeForm;
import cscd212enums.DifficultyLevel;

import java.util.ArrayList;

/**
 * GameBoard class
 */
public abstract class GameBoard {

    /**
     * ArrayList of LifeForms representing the enemies
     */
    protected ArrayList<LifeForm> enemyLifeForms;

    /**
     * LifeForm representing the player
     */
    protected LifeForm player;

    /**
     * GameBoard constructor. creates enemyLifeForms and adjusts difficulty
     * @param difficultyLevel DifficultyLevel
     */
    public GameBoard(DifficultyLevel difficultyLevel) {
        enemyLifeForms = new ArrayList<>();
        createLifeForms();
        adjustForDifficulty(difficultyLevel);
        enemyLifeForms.trimToSize();

    }

    /**
     * Get the player
     * @return LifeForm
     */
    public LifeForm getPlayer(){
        return player;
    }

    /**
     * Get the enemyLifeForms
     * @return ArrayList of LifeForms
     */
    public ArrayList<LifeForm> getEnemyLifeForms(){
        return enemyLifeForms;
    }

    /**
     * Adjust the enemyLifeForms health for the difficulty
     * @param difficultyLevel DifficultyLevel
     */
    protected void adjustForDifficulty(DifficultyLevel difficultyLevel) {
        for(LifeForm enemy : enemyLifeForms){
            enemy.setCurrentLifePoints((int) (enemy.getCurrentLifePoints() * difficultyLevel.getModifier()));
        }
    }

    /**
     * Create life forms for the board, abstract
     */
    protected abstract void createLifeForms();


}
