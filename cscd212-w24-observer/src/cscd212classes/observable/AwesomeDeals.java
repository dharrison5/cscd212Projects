package cscd212classes.observable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class represents the AwesomeDeals class
 */
public class AwesomeDeals {

    /** the hourly deal */
    private String hourly;

    /** the daily deal */
    private String daily;

    /** the property change support for event listening*/
    private PropertyChangeSupport propertyChangeSupport;

    /**
     * The constructor that initializes the hourly and daily deals
     * and the property change support
     */
    public AwesomeDeals() {
        this.hourly = "Hourly Deal";
        this.daily = "Daily Deal";
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    /**
     * This method subscribes the daily deal
     */
    public void subscribeDaily() {
        this.propertyChangeSupport.firePropertyChange("Subscribed Daily:", null, this.daily);
    }

    /**
     * This method subscribes the hourly deal
     */
    public void subscribeHourly() {
        this.propertyChangeSupport.firePropertyChange("Subscribed Hourly:", null, this.hourly);
    }

    /**
     * This method changes the daily deal
     * @param daily The new daily deal
     */
    public void changeDaily(String daily){
        String tempDaily = this.daily;
        this.daily = daily;
        this.propertyChangeSupport.firePropertyChange("New Daily:", tempDaily, this.daily);
    }

    /**
     * This method changes the hourly deal
     * @param hourly The new hourly deal
     */
    public void changeHourly(String hourly){
        String tempHourly = this.hourly;
        this.hourly = hourly;
        this.propertyChangeSupport.firePropertyChange("New Hourly:", tempHourly, this.hourly);
    }

    /**
     * This method returns the daily deal
     * @return The daily deal
     */
    public String getDaily(){
        return this.daily;
    }

    /**
     * This method returns the hourly deal
     * @return The hourly deal
     */
    public String getHourly(){
        return this.hourly;
    }

    /**
     * This method adds a listener to the property change support
     * @param pc1 The listener to add
     */
    public void addPropertyChangeListener(PropertyChangeListener pc1){
        this.propertyChangeSupport.addPropertyChangeListener(pc1);
    }

    /**
     * This method removes a listener from the property change support
     * @param pc1 The listener to remove
     */
    public void removePropertyChangeListener(PropertyChangeListener pc1){
        this.propertyChangeSupport.removePropertyChangeListener(pc1);
    }
}
