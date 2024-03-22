package ticketing.planes;

import ticketing.flyBehavior.WarpFly;

/**
 * MillenniumFalcon is a subclass of Plane
 */
public class MillenniumFalcon extends Plane{

    /**
     * Constructor for MilleniumFalcon with preset values
     */
    public MillenniumFalcon(){
        super("Millennium Falcon", 10, new WarpFly());
    }
}
