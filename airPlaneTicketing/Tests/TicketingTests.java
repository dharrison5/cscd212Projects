import org.junit.*;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;
import ticketing.airports.*;
import ticketing.builder.*;
import ticketing.classes.*;
import ticketing.decorator.*;
import ticketing.flyBehavior.*;
import ticketing.planes.*;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TicketingTests {
    private TicketBuilder ticketBuilder;
    private Ticket ticket;
    private Airport airport;
    private Plane plane;
    private TicketDecorator ticketDecorator;
    private FlyBehavior flyBehavior;

    @BeforeEach
    public void setUp() {
        ticketBuilder = new TicketBuilder("Devin Harrison");

        ticketBuilder.addAirport(new Phoenix());
        ticketBuilder.addAirport(new Spokane());
        ticketBuilder.addAirport(new Tatooine());


        ticketBuilder.setPlane(new MillenniumFalcon());

        ticketBuilder.decorate(new FirstClassDecor());
        ticketBuilder.decorate(new CheckedBagDecor());
        ticketBuilder.decorate(new InFlightMealDecor());

        ticket = ticketBuilder.getTicket();
    }

    @Test
    void testTicketDescription() {
        System.out.println(ticket);
        assertEquals("Ticket for: Devin Harrison\n" +
                " Vessel: \tMillennium Falcon\n" +
                " From: \t\tPHX to GEG to TAT for a total distance of 2689793.2 miles\n" +
                " For: \t\t$2300\n" +
                " With: \t\tA First Class Seat, A Checked Bag, An In-Flight Meal", ticket.toString());
    }

    @Test
    void testTicket() {
        assertEquals("Devin Harrison", ticket.getPassengerName());
        assertEquals(3, ticket.getAirports().size());
        assertEquals("PHX", ticket.getAirports().get(0).getAirportCode());
        assertEquals("GEG", ticket.getAirports().get(1).getAirportCode());
        assertEquals("TAT", ticket.getAirports().get(2).getAirportCode());
        assertEquals("Millennium Falcon", ticket.getPlane().getName());
        assertEquals(2300, ticketBuilder.getCost());
    }

    @Test
    void testAirport() {
        airport = new Phoenix();
        assertEquals("PHX", airport.getAirportCode());
        assertEquals((Integer)300, airport.getCost());
        assertEquals((Integer)2277, airport.getCoordinates()[0]);
        assertEquals((Integer)6048, airport.getCoordinates()[1]);
    }

    @Test
    void testPlane() {
        plane = new MillenniumFalcon();
        assertEquals("Millennium Falcon", plane.getName());
        assertEquals(10, plane.getCapacity());
        assertEquals("WarpFly", plane.getFlyBehavior().getClass().getSimpleName());
        plane.setFlyBehavior(new JetFly());
        assertEquals("JetFly", plane.getFlyBehavior().getClass().getSimpleName());
    }

    @Test
    void testBuilderReset(){
        ticketBuilder.reset();
        assertEquals(0, ticketBuilder.getCost());
        assertEquals(null, ticketBuilder.getPlane());
        assertEquals(null, ticketBuilder.getPassengerName());
        assertEquals(0, ticketBuilder.getAirports().size());
        assertEquals(ticketBuilder, ticketBuilder.getTicketDecorator());
    }

}
