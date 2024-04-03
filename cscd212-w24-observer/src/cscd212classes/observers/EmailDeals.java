package cscd212classes.observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import cscd212classes.observable.AwesomeDeals;

/**
 * This class represents the EmailDeals class
 */
public class EmailDeals implements PropertyChangeListener{

    /** the daily email */
    private String email1;

    /** the hourly email */
    private String email2;

    /** the observable object */
    private AwesomeDeals awesomeDeals;

    /**
     * The constructor that takes in an AwesomeDeals object
     * and adds itself as a listener to the object
     * @param awesomeDeals The AwesomeDeals object
     */
    public EmailDeals(AwesomeDeals awesomeDeals) {
        this.awesomeDeals = awesomeDeals;
        this.awesomeDeals.addPropertyChangeListener(this);
    }

    /**
     * This method subscribes the email to the daily deals
     * @param email The email to subscribe
     */
    public void subscribeDaily(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Invalid params EmailDeals subscribeDaily");
        }
        this.email1 = email;
        this.awesomeDeals.subscribeDaily();
    }

    /**
     * This method subscribes the email to the hourly deals
     * @param email The email to subscribe
     */
    public void subscribeHourly(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Invalid params EmailDeals subscribeHourly");
        }
        this.email2 = email;
        this.awesomeDeals.subscribeHourly();
    }

    /**
     * This method unsubscribes the email from the daily deals
     * @param email The email to unsubscribe
     */
    public void unsubscribeDaily(String email) {
        if (email == null || !email.equals(this.email1)) {
            System.out.println("Email: [" + email + "] Does not exist");
        }
        else {
            this.email1 = null;
            if(this.email2 == null) {
                this.awesomeDeals.removePropertyChangeListener(this);
            } else {
                System.out.println("Removed Daily Email: [" + email + "]");
            }
        }
    }

    /**
     * This method unsubscribes the email from the hourly deals
     * @param email The email to unsubscribe
     */
    public void unsubscribeHourly(String email) {
        if (email == null || !email.equals(this.email2)) {
            System.out.println("Email: [" + email + "] Does not exist");
        }
        else {
            this.email2 = null;
            if(this.email1 == null) {
                this.awesomeDeals.removePropertyChangeListener(this);
            } else {
                System.out.println("Removed Hourly Email: [" + email + "]");
            }
        }
    }

    /**
     * listens for events and prints out the changes
     * @param event A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    public void propertyChange(PropertyChangeEvent event){
        if(event.getOldValue() == null)
            System.out.println("EmailDeals " + event.getPropertyName() + " [" + event.getNewValue() + "]");
        else
            System.out.println("EmailDeals " + event.getPropertyName() +
                    " [" + event.getOldValue() + "] -> " + " [" + event.getNewValue() + "]");
    }
}
