package ticketing.flyBehavior;

/**
 * a propellor implementation of the FlyBehavior interface
 */
public class PropFly implements FlyBehavior{

    /**
     * prints a message to the console about propellor flight
     */
    public void fly() {
        System.out.println("I'm flying at 210 mph with propellers!");
    }
}
