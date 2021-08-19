package Model;

/**
 * A class to represent a customer's address.
 */
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
    
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Returns a customer's street address.
     *
     * @return A string representing the street address of a customer.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets a customer's street address.
     *
     * @param street Sets the string representing the customer's street address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Returns a customer's city.
     *
     * @return A string representing the customer's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets a customer's city.
     *
     * @param city Sets the string representing the customer's city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns a customer's state.
     *
     * @return A string representing the customer's state.
     */

    public String getState() {
        return state;
    }

    /**
     * Sets a customer's state.
     *
     * @param state Sets the string representing the customer's state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns a customer's zip code.
     *
     * @return A string representing the customer's zip code.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets a customer's zip code.
     *
     * @param zip Sets the string representing the customer's zip code.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Returns a customer's full address.
     *
     * @return String representing the customer's full address.
     */
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + ", " + zip;
    }
}