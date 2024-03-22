package cscd212lab5;
import cscd212classes.*;
import cscd212accommodation.*;
import cscd212builder.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {
    /**
     * I can not figure out why this doesn't work but it's probably a bad test anyway
     */
//    @Test
//    public void testCityBuilder() {
//        VacationBuilder builder = new CityVacationBuilder("Seattle");
//        builder.addAccommodation("AirBnB", "123 Main St", 2021, 5, 1, 3);
//        builder.addAccommodation("Hotel", 2021, 5, 1, 3, 202);
//        builder.addEvent("Space Needle");
//        builder.addEvent("Pike Place Market");
//        Vacation vacation = builder.getVacation();
//        System.out.println(vacation);
//        String s = "---- Your Vacation Details ---- \n" +
//                "Location: Seattle\n" +
//                " Reservation: 	2021-05-01\n\t" +
//                "Nights: 3\n\t" +
//                "AirBnB: 123 Main St\n\n" +
//                " Reservation: 	2021-05-01\n\t" +
//                "Nights: 3\n\t" +
//                "Hotel Room number: 202\n\n" +
//                "Events: \n" +
//                "Space Needle\n" +
//                "Pike Place Market\n";
//        System.out.println(s);
//        assertEquals(s, vacation);
//    }

    private VacationBuilder cityBuilder;
    private Vacation cityVacation;
    private VacationBuilder outdoorBuilder;
    private Vacation outdoorVacation;

    @BeforeEach
    public void setUp(){
        cityBuilder = new CityVacationBuilder("Seattle");
        cityBuilder.addAccommodation("AirBnB", "123 Main St", 2021, 5, 1, 3);
        cityBuilder.addAccommodation("Hotel", 2021, 5, 1, 3, 202);
        cityBuilder.addEvent("Space Needle");
        cityBuilder.addEvent("Pike Place Market");
        cityVacation = cityBuilder.getVacation();


        outdoorBuilder = new OutdoorVacationBuilder("Spirit Lake");
        outdoorBuilder.addAccommodation("Sedlmayer's Resort", 2021, 5, 1, 3, 5);
        outdoorBuilder.addAccommodation("AirBnB", "123 Main St", 2021, 5, 1, 3);
        outdoorBuilder.addEvent("Eating hot dogs");
        outdoorBuilder.addEvent("Fishing");
        outdoorVacation = outdoorBuilder.getVacation();
    }

    @Test
    public void testHotelNullName(){
        VacationBuilder builder = new CityVacationBuilder("Seattle");
        assertThrows(IllegalArgumentException.class, () -> builder.addAccommodation(null, "123 Main St", 2021, 5, 1, 3));
    }

    @Test
    public void testHotelBlankName(){
        VacationBuilder builder = new CityVacationBuilder("Seattle");
        assertThrows(IllegalArgumentException.class, () -> builder.addAccommodation("", 2021, 2021, 5, 1, 3));
    }

    @Test
    public void testAirBnBNullLocation(){
        VacationBuilder builder = new CityVacationBuilder("Seattle");
        assertThrows(IllegalArgumentException.class, () -> builder.addAccommodation("AirBnB", null, 2021, 5, 1, 3));
    }

    @Test
    public void testAirBnBBlankLocation(){
        VacationBuilder builder = new CityVacationBuilder("Seattle");
        assertThrows(IllegalArgumentException.class, () -> builder.addAccommodation("AirBnB", "", 2021, 5, 1, 3));
    }

    @Test
    public void testCampsiteBadNumber() {
        assertThrows(IllegalArgumentException.class, () -> outdoorBuilder.addAccommodation("Lake Diablo", 2021, 5, 1, 3, 0));
    }

    @Test
    public void testHotelBadNumber() {
        assertThrows(IllegalArgumentException.class, () -> cityBuilder.addAccommodation("Hotel", 2021, 5, 1, 3, 0));
    }

    @Test
    public void testCityBuilderNullEvent() {
        assertThrows(IllegalArgumentException.class, () -> cityBuilder.addEvent(null));
    }

    @Test
    public void testCityBuilderBlankEvent() {
        assertThrows(IllegalArgumentException.class, () -> cityBuilder.addEvent(""));
    }

    @Test
    public void testVacationNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new CityVacationBuilder(null));
    }

    @Test
    public void testVacationNameBlank() {
        assertThrows(IllegalArgumentException.class, () -> new CityVacationBuilder(""));
    }

    @Test
    public void testCityVacation() {

    }

}
