package ticketing.planes;

import ticketing.flyBehavior.PropFly;

/**
 * Cessna is a subclass of Plane
 */
public class Cessna extends Plane{

    /**
     * Constructor for Cessna with preset values
     */
    public Cessna(){
        super("Cessna 170", 4, new PropFly());
    }
}
