package ticketing.airports;

/**
 * Abstract airport superclass for building airports with necessary information
 * implements Comparable interface to compare airports
 */
public abstract class Airport implements Comparable<Airport>{

    /** Airport code */
    private final String airportCode;

    /** Cost of airport */
    private final Integer cost;

    /** Coordinates of airport, scales from degrees to miles */
    private final Integer[] coordinates = new Integer[2];
    private static final Integer LATITUDE_MILES_PER_DEGREE = 69;
    private static final Integer LONGITUDE_MILES_PER_DEGREE = 54;

    /**
     * Constructor for Airport, converts degrees to miles for coordinates
     * @param airportCode String airport code
     * @param cost Integer cost of airport
     * @param coordinates Integer[] coordinates of airport in degrees
     */
    public Airport(String airportCode, Integer cost, Integer[] coordinates){
        if(airportCode == null || airportCode.isBlank() || cost < 0 || coordinates == null || coordinates.length != 2)
            throw new IllegalArgumentException("Invalid airportCode or cost Airport");

        this.airportCode = airportCode;
        this.cost = cost;
        this.coordinates[0] = coordinates[0] * LATITUDE_MILES_PER_DEGREE;
        this.coordinates[1] = coordinates[1] * LONGITUDE_MILES_PER_DEGREE;

    }

    /**
     * Getter for airport code
     * @return String airport code
     */
    public String getAirportCode(){
        return airportCode;
    }

    /**
     * Getter for cost of airport
     * @return Integer cost of airport
     */
    public Integer getCost(){
        return cost;
    }

    /**
     * Getter for coordinates of airport
     * @return Integer[] coordinates of airport
     */
    public Integer[] getCoordinates(){
        return coordinates;
    }

    /**
     * Compares airports based on airport code
     * @param o the object to be compared.
     * @return int negative if this is less, 0 if equal, positive if greater
     */
    @Override
    public int compareTo(Airport o){
        return this.getAirportCode().compareTo(o.getAirportCode());
    }

}

