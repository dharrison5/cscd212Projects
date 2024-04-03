package cscd212classes.factories;

import cscd212classes.boards.*;
import cscd212enums.BoardTheme;
import cscd212enums.DifficultyLevel;

/**
 * GameBoardFactory class
 */
public class GameBoardFactory {

    /**
     * GameBoardFactory constructor
     */
    public GameBoardFactory() {};

    /**
     * Return a game board based on the level theme and difficulty level
     * @param levelTheme BoardTheme
     * @param difficultyLevel DifficultyLevel
     * @return GameBoard
     */
    public static GameBoard getGameBoard(BoardTheme levelTheme, DifficultyLevel difficultyLevel) {
        return switch (levelTheme) {
            case EARTH -> new EarthBoard(difficultyLevel);
            case MARS -> new MarsBoard(difficultyLevel);
            case FANTASY -> new FantasyBoard(difficultyLevel);
            default -> null;
        };
    }

}
