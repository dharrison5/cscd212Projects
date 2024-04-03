import cscd212classes.boards.*;
import cscd212classes.factories.*;
import cscd212classes.lifeform.*;
import cscd212enums.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    DifficultyLevel EASY = DifficultyLevel.EASY;
    DifficultyLevel HARD = DifficultyLevel.HARD;
    DifficultyLevel INSANE = DifficultyLevel.INSANE;
    DifficultyLevel NORMAL = DifficultyLevel.NORMAL;

    BoardTheme EARTH = BoardTheme.EARTH;
    BoardTheme FANTASY = BoardTheme.FANTASY;
    BoardTheme MARS = BoardTheme.MARS;

    GameBoard earthEasy;
    GameBoard earthHard;
    GameBoard earthInsane;
    GameBoard earthNormal;

    GameBoard fantEasy;
    GameBoard fantHard;
    GameBoard fantInsane;
    GameBoard fantNormal;

    GameBoard marsEasy;
    GameBoard marsHard;
    GameBoard marsInsane;
    GameBoard marsNormal;

    @BeforeEach
    public void setUp() {
        fantEasy = GameBoardFactory.getGameBoard(FANTASY, EASY);
        fantHard = GameBoardFactory.getGameBoard(FANTASY, HARD);
        fantInsane = GameBoardFactory.getGameBoard(FANTASY, INSANE);
        fantNormal = GameBoardFactory.getGameBoard(FANTASY, NORMAL);

        earthEasy = GameBoardFactory.getGameBoard(EARTH, EASY);
        earthHard = GameBoardFactory.getGameBoard(EARTH, HARD);
        earthInsane = GameBoardFactory.getGameBoard(EARTH, INSANE);
        earthNormal = GameBoardFactory.getGameBoard(EARTH, NORMAL);

        marsEasy = GameBoardFactory.getGameBoard(MARS, EASY);
        marsHard = GameBoardFactory.getGameBoard(MARS, HARD);
        marsInsane = GameBoardFactory.getGameBoard(MARS, INSANE);
        marsNormal = GameBoardFactory.getGameBoard(MARS, NORMAL);
    }

    @Test
    public void testGetLifeForm(){
        assertThrows(IllegalArgumentException.class, () -> LifeFormFactory.getLifeForm(LifeFormType.HUMAN, "Dave", 0));
        assertThrows(IllegalArgumentException.class, () -> LifeFormFactory.getLifeForm(LifeFormType.HUMAN, null, 1));
        assertThrows(IllegalArgumentException.class, () -> LifeFormFactory.getLifeForm(LifeFormType.HUMAN, "", 1));
    }

    @Test
    public void testLifeFormConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new Human("Dave", 0));
        assertThrows(IllegalArgumentException.class, () -> new Human(null, 1));
        assertThrows(IllegalArgumentException.class, () -> new Human("", 1));
    }

    @Test
    public void testSetCurrentLifePoints() {
        Human human = new Human("Dave", 100);
        assertThrows(IllegalArgumentException.class, () -> human.setCurrentLifePoints(-1));
    }

    @Test
    public void testGameBoardPlayer(){
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.MARTIAN).toString(), earthEasy.getPlayer().toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HALF_ORC).toString(), fantEasy.getPlayer().toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN).toString(), marsEasy.getPlayer().toString());
    }

    @Test
    public void testGameBoardEnemiesSize(){
        assertEquals(2, earthEasy.getEnemyLifeForms().size());
        assertEquals(3, fantEasy.getEnemyLifeForms().size());
        assertEquals(4, marsEasy.getEnemyLifeForms().size());
    }

    @Test
    public void testEarthEnemies(){
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN, "Dave", 110).toString(), earthNormal.getEnemyLifeForms().get(0).toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN).toString(), earthNormal.getEnemyLifeForms().get(1).toString());
    }

    @Test
    public void testMarsEnemies(){
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.MARTIAN).toString(), marsNormal.getEnemyLifeForms().get(0).toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.MARTIAN, "Steve", 50).toString(), marsNormal.getEnemyLifeForms().get(1).toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN, "Evil Carl", 110).toString(), marsNormal.getEnemyLifeForms().get(2).toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN, "Carl", 100).toString(), marsNormal.getEnemyLifeForms().get(3).toString());
    }

    @Test
    public void testFantasyEnemies(){
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.KRYPTON).toString(), fantNormal.getEnemyLifeForms().get(0).toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.KRYPTON, "Uzguk", 80).toString(), fantNormal.getEnemyLifeForms().get(1).toString());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN, "Dave", 110).toString(), fantNormal.getEnemyLifeForms().get(2).toString());
    }

    @Test
    public void testLifePointModifier(){
        double easy = 0.7;
        double normal = 1;
        double hard = 1.5;
        double insane = 2;

        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN).getCurrentLifePoints() * easy, earthEasy.getEnemyLifeForms().get(1).getCurrentLifePoints());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN).getCurrentLifePoints() * normal, earthNormal.getEnemyLifeForms().get(1).getCurrentLifePoints());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN).getCurrentLifePoints() * hard, earthHard.getEnemyLifeForms().get(1).getCurrentLifePoints());
        assertEquals(LifeFormFactory.getLifeForm(LifeFormType.HUMAN).getCurrentLifePoints() * insane, earthInsane.getEnemyLifeForms().get(1).getCurrentLifePoints());



    }
}
