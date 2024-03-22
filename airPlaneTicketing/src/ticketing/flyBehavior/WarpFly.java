package ticketing.flyBehavior;

/**
 * a warp drive implementation of the FlyBehavior interface
 */
public class WarpFly implements FlyBehavior{

    /**
     * prints a message to the console about warp flight
     */
        public void fly() {
            System.out.println("I'm doing the Kessel run in 12 parsecs!");
        }
}
