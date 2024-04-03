package cscd212classes.lab3;

import cscd212classes.observable.AwesomeDeals;
import cscd212classes.observers.EmailDeals;
import cscd212classes.observers.TextDeals;

/**
 * This is the class that contains main. I didn't have time to write tests, so we are just going to use the output from main.
 * Timbre will write tests.
 * <br>NOTE: For this lab and only this lab we are not worrying about preconditions.
 */
public class ObserverPatternClient
{
   /**
    * The main method that is used to temporarily used to test your solution
    * @param args Representing command line arguments
    */
   public static void main(final String [] args)
   {
      AwesomeDeals awesomeDeals = new AwesomeDeals();
      EmailDeals myEmails = new EmailDeals(awesomeDeals);


      myEmails.subscribeDaily("ssteiner@ewu.edu");
      myEmails.subscribeHourly("stusteiner@aol.com");
      System.out.println();

      awesomeDeals.changeDaily("Daily Day 2");
      awesomeDeals.changeHourly("Hourly Deal 2");
      System.out.println();

      TextDeals myPhone = new TextDeals(awesomeDeals);
      myPhone.subscribeDaily("509-111-2233");
      myPhone.subscribeHourly("509-111-2233");
      System.out.println();

      myEmails.unsubscribeHourly("stusteiner@yahoo.com");
      System.out.println();

      awesomeDeals.changeHourly("Hourly Deal 3");
      System.out.println();

      myEmails.unsubscribeHourly("stusteiner@aol.com");
      System.out.println();

      awesomeDeals.changeHourly("Hourly Deal 4");
      System.out.println();

      myPhone.unsubscribeAll("509-111-2233");
      awesomeDeals.changeHourly("Hourly Deal 5");
      System.out.println();

      awesomeDeals.changeDaily("Daily Day 3");





   }// end main
}// end class