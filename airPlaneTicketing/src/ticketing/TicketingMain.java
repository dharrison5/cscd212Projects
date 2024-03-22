package ticketing;
import ticketing.airports.*;
import ticketing.builder.*;
import ticketing.classes.*;
import ticketing.decorator.*;
import ticketing.planes.*;

import java.util.Scanner;
/**
 * Main class for the ticketing system
 * Simple UI for making a reservation
 */
public class TicketingMain {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Reservation reservation = new Reservation();
        TicketBuilder tb;
        int newTicket = 0;

        while(newTicket == 0) {

            System.out.println("Welcome to the Ticketing System!");
            System.out.println("Please enter your name.");
            System.out.print("Name: ");
            tb = new TicketBuilder(kb.next());

            System.out.println("Which airport will you be flying from?");
            System.out.println("1: Spokane");
            System.out.println("2: Phoenix");
            System.out.println("3: Tatooine");
            System.out.print("Enter selection: ");
            int choice = kb.nextInt();

            switch (choice) {
                case 1:
                    tb.addAirport(new Spokane());
                    break;
                case 2:
                    tb.addAirport(new Phoenix());
                    break;
                case 3:
                    tb.addAirport(new Tatooine());
                    break;
            }

            int moreAirports = 0;
            int numAirports = 0;

            while (moreAirports == 0 || numAirports < 1) {
                System.out.println("Please choose next airport to fly to: ");
                System.out.println("1: Spokane");
                System.out.println("2: Phoenix");
                System.out.println("3: Tatooine");
                System.out.println("4: Done");
                System.out.print("Enter selection:");
                choice = kb.nextInt();

                switch (choice) {
                    case 1:
                        tb.addAirport(new Spokane());
                        numAirports++;
                        break;
                    case 2:
                        tb.addAirport(new Phoenix());
                        numAirports++;
                        break;
                    case 3:
                        tb.addAirport(new Tatooine());
                        numAirports++;
                        break;
                    case 4:
                        moreAirports = 1;
                        break;
                }
            }

            System.out.println("Which vessel will you be flying on?");
            System.out.println("1. Cessna 170");
            System.out.println("2. Boeing 747");
            System.out.println("3. Millenium Falcon");
            choice = kb.nextInt();
//        kb.next();

            Plane plane = null;
            switch (choice) {
                case 1:
                    plane = new Cessna();
                    break;
                case 2:
                    plane = new Boeing747();
                    break;
                case 3:
                    plane = new MillenniumFalcon();
                    break;
            }
            if (plane != null) {
                plane.fly();
                tb.setPlane(plane);
            }

            moreAirports = 0;
            while (moreAirports == 0) {
                System.out.println("Select an addon for your ticket");
                System.out.println("1: Checked Bag");
                System.out.println("2: First Class Seat");
                System.out.println("3: In-Flight Meal");
                System.out.println("4: Done");
                System.out.print("Enter selection: ");
                choice = kb.nextInt();
//            kb.next();

                switch (choice) {
                    case 1:
                        tb.decorate(new CheckedBagDecor());
                        break;
                    case 2:
                        tb.decorate(new FirstClassDecor());
                        break;
                    case 3:
                        tb.decorate(new InFlightMealDecor());
                        break;
                    case 4:
                        moreAirports = 1;
                        break;
                }
            }
            reservation.addTicket(tb.getTicket());
            System.out.println("Would you like to add another ticket?");
            System.out.println("1: Yes");
            System.out.println("2: No");
            System.out.println("Enter selection: ");
            if(kb.nextInt() == 1){
                tb.reset();
                kb.nextLine();
            }else if(kb.nextInt() == 2){
                newTicket = 1;
                System.out.println(reservation);
            }else{
                System.out.println("Invalid input, returning to main menu.");
            }
        }
        }
}
