package cscd212classes.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import cscd212classes.observable.AwesomeDeals;

/**
 * This class represents the TextDeals class
 */
public class TextDeals implements PropertyChangeListener {

    /** the phone number */
    private String phoneNumber;

    /** the observable object */
    private AwesomeDeals awesomeDeals;

    /**
     * The constructor that takes in an AwesomeDeals object
     * and adds itself as a listener to the object
     * @param awesomeDeals The AwesomeDeals object
     */
    public TextDeals(AwesomeDeals awesomeDeals) {
        this.awesomeDeals = awesomeDeals;
        this.awesomeDeals.addPropertyChangeListener(this);
    }

    /**
     * This method subscribes the phone number to the daily deals
     * @param phoneNumber The phone number to subscribe
     */
    public void subscribeDaily(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid params TextDeals subscribeDaily");
        } else if(this.phoneNumber == null) {
            this.phoneNumber = phoneNumber;
            this.awesomeDeals.subscribeDaily();
        }
    }

    /**
     * This method subscribes the phone number to the hourly deals
     * @param phoneNumber The phone number to subscribe
     */
    public void subscribeHourly(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid params TextDeals subscribeHourly");
        } else if(this.phoneNumber == null) {
            this.phoneNumber = phoneNumber;
            this.awesomeDeals.subscribeHourly();
        }
    }

    /**
     * This method unsubscribes the phone number from the daily and hourly deals
     * @param phoneNumber The phone number to unsubscribe
     */
    public void unsubscribeAll(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.equals(this.phoneNumber)) {
            System.out.println("Phone number: " + "[" + phoneNumber + "] " + " Does not exist");
        }
        else {
            this.phoneNumber = null;
            this.awesomeDeals.removePropertyChangeListener(this);
            System.out.println("Removed Phone Number: [" + phoneNumber + "]");
        }
    }

    /**
     * listens for events and prints out the changes
     * @param event A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    public void propertyChange(PropertyChangeEvent event){
        if(event.getOldValue() == null)
            System.out.println("TextDeals " + event.getPropertyName() + " [" + event.getNewValue() + "]");
        else
            System.out.println("TextDeals " + event.getPropertyName() +
                    " [" + event.getOldValue() + "] -> " + " [" + event.getNewValue() + "]");
    }
}
