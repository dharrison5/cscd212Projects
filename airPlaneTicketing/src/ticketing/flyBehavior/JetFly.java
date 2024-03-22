package ticketing.flyBehavior;

/**
 * a jet engine implementation of the FlyBehavior interface
 */
public class JetFly implements FlyBehavior{

    /**
     * prints a message to the console about jet flight
     */
    public void fly(){
        System.out.println("I'm flying at 500 mph with a jet engine!");
    }
}
