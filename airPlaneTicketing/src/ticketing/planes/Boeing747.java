package ticketing.planes;

import ticketing.flyBehavior.JetFly;

/**
 * Boeing747 is a subclass of Plane
 */
public class Boeing747 extends Plane{

    /**
     * Constructor for Boeing747 with preset values
     */
    public Boeing747(){
        super("Boeing 747", 366, new JetFly());
    }
}
