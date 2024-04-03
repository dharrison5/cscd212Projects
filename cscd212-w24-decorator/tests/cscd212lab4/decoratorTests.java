package cscd212lab4;

import cscd212classes.trees.*;
import cscd212classes.decorations.*;
import cscd212interfaces.HolidayItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class decoratorTests {

    private BalsamFir firTree;
    private Angel firAngel;
    private BallsGreen firBalls;
    private GoldTinsel firGold;
    private LightsLED firLights;
    private RedRibbon firRibbon;
    private SnowflakesClear firFlakes;
    private Star firStar;
    private ColoradoBlueSpruce coloTree;
    private Angel coloAngel;
    private BallsGreen coloBalls;
    private GoldTinsel coloGold;
    private LightsLED coloLights;
    private RedRibbon coloRibbon;
    private SnowflakesClear coloFlakes;
    private Star coloStar;


    @BeforeEach
    void buildBigTrees(){
        firTree = new BalsamFir(1);
        firAngel = new Angel(firTree, 3);
        firBalls = new BallsGreen(firAngel, 5);
        firGold = new GoldTinsel(firBalls, 7);
        firLights = new LightsLED(firGold, 11);
        firRibbon = new RedRibbon(firLights, 13);
        firFlakes = new SnowflakesClear(firRibbon, 17);
        firStar = new Star(firFlakes, 19);

        coloTree = new ColoradoBlueSpruce(1);
        coloStar = new Star(coloTree, 3);
        coloAngel = new Angel(coloStar, 5);
        coloFlakes = new SnowflakesClear(coloAngel, 7);
        coloBalls = new BallsGreen(coloFlakes, 11);
        coloRibbon = new RedRibbon(coloBalls, 13);
        coloGold = new GoldTinsel(coloRibbon, 17);
        coloLights = new LightsLED(coloGold, 19);

    }
    @Test
    void testFirNullName(){
    }
    @Test
    void testBalsamFirToString(){
        assertEquals("My tree is a Balsam Fir ", firTree.toString());
    }
    @Test
    void testFirAngel(){
        assertEquals("My tree is a Balsam Fir with" +
                " an angel, ", firAngel.getDescription());
    }
    @Test
    void testFirBalls(){
        assertEquals("My tree is a Balsam Fir with " +
                "an angel, " +
                "green balls, ", firBalls.getDescription());
    }
    @Test
    void testFirGold(){
        assertEquals("My tree is a Balsam Fir with " +
                        "an angel, " +
                        "green balls, " +
                        "gold tinsel, ",
                firGold.getDescription());
    }
    @Test
    void testFirLights(){
        assertEquals("My tree is a Balsam Fir with " +
                        "an angel, " +
                        "green balls, " +
                        "gold tinsel, " +
                        "LED lights, ",
                firLights.getDescription());
    }
    @Test
    void testFirRibbon(){
        assertEquals("My tree is a Balsam Fir with " +
                        "an angel, " +
                        "green balls, " +
                        "gold tinsel, " +
                        "LED lights, " +
                        "a red ribbon, ",
                firRibbon.getDescription());
    }
    @Test
    void testFirFlakes(){
        assertEquals("My tree is a Balsam Fir with " +
                        "an angel, " +
                        "green balls, " +
                        "gold tinsel, " +
                        "LED lights, " +
                        "a red ribbon, " +
                        "clear snowflakes, ",
                firFlakes.getDescription());
    }
    @Test
    void testFirStar(){
        assertEquals("My tree is a Balsam Fir with " +
                        "an angel, " +
                        "green balls, " +
                        "gold tinsel, " +
                        "LED lights, " +
                        "a red ribbon, " +
                        "clear snowflakes, " +
                        "a star, ",
                firStar.getDescription());
    }
    @Test
    void testColoradoToString(){
        assertEquals("My tree is a Colorado Blue Spruce ", coloTree.toString());
    }
    @Test
    void testColoAngel() {
        assertEquals("My tree is a Colorado Blue Spruce with " +
                "a star, " +
                "an angel, ", coloAngel.getDescription());
    }

    @Test
    void testFirPrice(){
        assertEquals(1, firTree.getCost());
    }
    @Test
    void testFirGoldPrice(){
        assertEquals(16, firGold.getCost());
    }
    @Test
    void testFirStarPrice(){
        assertEquals(76, firStar.getCost());
    }
    @Test
    void testColoPrice(){
        assertEquals(1, coloTree.getCost());
    }
    @Test
    void testColoFlakesPrice(){
        assertEquals(16, coloFlakes.getCost());
    }
    @Test
    void testColoLightsPrice(){
        assertEquals(76, coloLights.getCost());
    }
}
