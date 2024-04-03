package cscd212tests;

import cscd212classes.behavior.*;
import cscd212classes.lifeform.*;
import cscd212classes.recovery.*;
import cscd212classes.lifeform.Martian;

import cscd212interfaces.alienknowledge.*;
import cscd212interfaces.recovery.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


public class StrategyTests {

    private String testName;
    private int testCurrentLifePoints;
    private int testMaxLifePoints;
    private RecoveryBehavior testRecoveryFractional;
    private RecoveryBehavior testRecoveryLinear;
    private RecoveryBehavior testRecoveryNone;
    private AlienBehavior upArmorMax;
    private AlienBehavior upArmorPercentage;
    private int testArmorPoints;
    private int testDamage;
    private int testDamageBig;
    private int testDamageFatal;
    private Human testHuman;
    private Martian testMartian;
    private StarBellySneetch testStarBellySneetch;

    @BeforeEach
    public void initializeFields()
    {
        this.testName = "Test Name";
        this.testCurrentLifePoints = 100;
        this.testMaxLifePoints = 110;
        this.testRecoveryFractional = new RecoveryFractional(0.30);
        this.testRecoveryLinear = new RecoveryLinear(30);
        this.testRecoveryNone = new RecoveryNone();
        this.upArmorMax = new UpArmorMax();
        this.upArmorPercentage = new UpArmorPercentage();
        this.testArmorPoints = 50;
        this.testDamage = 10;
        this.testDamageBig = 80;
        this.testDamageFatal = 200;
        this.testHuman = new Human(this.testName, this.testCurrentLifePoints,
                this.testMaxLifePoints, this.testArmorPoints, this.upArmorPercentage);
        this.testMartian = new Martian(this.testName, this.testCurrentLifePoints, this.testMaxLifePoints,
                this.testRecoveryFractional);
        this.testStarBellySneetch = new StarBellySneetch(this.testName, this.testCurrentLifePoints,
                this.testMaxLifePoints, this.testRecoveryFractional);
    }


    @Test
    @DisplayName("exception on name is null")
    public void nameIsNull()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            new Human(null,
                    testCurrentLifePoints,
                    testMaxLifePoints,
                    testArmorPoints,
                    upArmorMax);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Martian(null,
                    testCurrentLifePoints);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new StarBellySneetch(null,
                    testCurrentLifePoints);
        });
    }

    @Test
    @DisplayName("Test Empty Names")
    public void testEmptyNames(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Human("",
                    testCurrentLifePoints,
                    testMaxLifePoints,
                    testArmorPoints,
                    upArmorMax);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Martian("",
                    testCurrentLifePoints);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new StarBellySneetch("",
                    testCurrentLifePoints);
        });
    }

    @Test
    @DisplayName("setCurrentLife below 0")
    public void testNegativeCurrentHealth(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Human(testName,
                    -1,
                    testMaxLifePoints,
                    testArmorPoints,
                    upArmorMax);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Martian(testName,
                    -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new StarBellySneetch(testName,
                    -1);
        });
    }

    @Test
    @DisplayName("setMaxLife below 0")
    public void testNegativeMaxHealth(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Human(testName,
                    testCurrentLifePoints,
                    -1,
                    testArmorPoints,
                    upArmorMax);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Martian(testName,
                    testCurrentLifePoints,
                    -1,
                    testRecoveryFractional);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new StarBellySneetch(testName,
                    testCurrentLifePoints,
                    -1,
                    testRecoveryLinear);
        });
    }

    @Test
    @DisplayName("set human armorPoints below 0")
    public void testNegativeArmorPoints(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Human(testName,
                    testCurrentLifePoints,
                    testMaxLifePoints,
                    -1,
                    upArmorMax);
        });
    }

    @Test
    @DisplayName("set null recovery")
    public void testNullRecovery(){

        assertThrows(IllegalArgumentException.class, () -> {
            new Martian(testName,
                    testCurrentLifePoints,
                    testMaxLifePoints,
                    null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new StarBellySneetch(testName,
                    testCurrentLifePoints,
                    testMaxLifePoints,
                    null);
        });
    }

    @Test
    @DisplayName("Human armor hit")
    public void testHumanArmorHit(){
        testHuman.takeHit(40);
        assertEquals(testArmorPoints - 40, testHuman.getArmorPoints());
    }

    @Test
    @DisplayName("Human health hit")
    public void testHumanHealthHit(){

        testHuman.takeHit(testDamageBig);
        assertEquals(Math.max(0, testArmorPoints - testDamageBig), testHuman.getArmorPoints());
        assertEquals(testCurrentLifePoints - testDamageBig + testArmorPoints, testHuman.getLifePoints());
    }

    @Test
    @DisplayName("Human set armor percent test")
    public void testSetHumanArmorPercent(){
        for(int i = 0; i < 100; i++) {
            testHuman.setArmorPoints(testArmorPoints);
            assertTrue(testHuman.getArmorPoints() >= testArmorPoints
                    && testHuman.getArmorPoints() <= testArmorPoints * 2);
        }
    }

    @Test
    @DisplayName("Human set armor max test")
    public void testSetHumanArmorMax(){
        testHuman.setAlienBehavior(upArmorMax);
        for(int i = 0; i < 100; i++) {
            testHuman.setArmorPoints(testArmorPoints);
            assertTrue(testHuman.getArmorPoints() == testArmorPoints
                    || testHuman.getArmorPoints() == testArmorPoints * 2);
        }
    }

    @Test
    @DisplayName("Human toString test")
    public void testHumanToString(){
        assertEquals(testName + " has " +
                        testCurrentLifePoints + " life points and "
                        + testArmorPoints + " armor points", testHuman.toString());
    }

    @Test
    @DisplayName("Martian recovery fractional test")
    public void testMartianRecoveryFractional(){
        testMartian.setRecoveryBehavior(testRecoveryFractional);
        testMartian.setCurrentLifePoints(50);
        testMartian.recover();
        assertEquals(50 * 1.3, testMartian.getLifePoints());
    }

    @Test
    @DisplayName("Martian recovery fractional string test")
    public void testMartianRecoveryFractionalString(){
        testMartian.setRecoveryBehavior(testRecoveryFractional);
        testMartian.setCurrentLifePoints(50);
        assertEquals("Test Name has had 15 recovery points added to their current life points",
                testMartian.recover());
    }

    @Test
    @DisplayName("Martian recovery linear test")
    public void testMartianRecoveryLinear(){
        testMartian.setRecoveryBehavior(testRecoveryLinear);
        testMartian.setCurrentLifePoints(50);
        testMartian.recover();
        assertEquals(50 + 30, testMartian.getLifePoints());
    }

    @Test
    @DisplayName("Martian recovery linear string test")
    public void testMartianRecoveryLinearString(){
        testMartian.setRecoveryBehavior(testRecoveryLinear);
        testMartian.setCurrentLifePoints(50);
        assertEquals("Test Name has had 30 recovery points added to their current life points",
                testMartian.recover());
    }

    @Test
    @DisplayName("Martian recovery none test")
    public void testMartianRecoveryNone(){
        testMartian.setRecoveryBehavior(testRecoveryNone);
        testMartian.setCurrentLifePoints(50);
        testMartian.recover();
        assertEquals(50, testMartian.getLifePoints());
    }

    @Test
    @DisplayName("Martian recovery none string test")
    public void testMartianRecoveryNoneString(){
        testMartian.setRecoveryBehavior(testRecoveryNone);
        testMartian.setCurrentLifePoints(50);
        assertEquals("Test Name has had 0 recovery points added to their current life points",
                testMartian.recover());
    }

    @Test
    @DisplayName("Martian toString test")
    public void testMartianToString(){
        assertEquals("Test Name has 100 life points and has recovery mode of RecoveryFractional",
                testMartian.toString());
    }

    @Test
    @DisplayName("StarBellySneetch toString test")
    public void testStarBellySneetchToString(){
        assertEquals("Test Name has 100 life points and has recovery mode of RecoveryFractional",
                testStarBellySneetch.toString());
    }

}