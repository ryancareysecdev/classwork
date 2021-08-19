package Model;

/**
 * A class representing customer.
 */
public class Customer extends Person{

    private String firstName;
    private String lastName;
    private Address address;
    private String birthday;
    private String phoneNumber;
    private int credit;
    private Identifier id;

    /**
     * A constructor for creating a customer.
     *
     * @param id A customer ID
     * @param firstName A customer's first name.
     * @param lastName A customer's last name.
     * @param address A customer's address.
     * @param birthday A customer's birthday.
     * @param phoneNumber A customer's phone number.
     */
    public Customer(Identifier id, String firstName, String lastName, Address address, String birthday, String phoneNumber, int credit) {
        super(id, firstName, lastName);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.credit = credit;
    }

    /**
     * Returns a customer's first name.
     *
     * @return A string representing the customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a customer's first name.
     *
     * @param firstName Sets the string representing the customer's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns a customer's last name.
     *
     * @return A string representing the customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a customer's last name.
     *
     * @param lastName Sets the string representing the customer's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a customer's address.
     *
     * @return Address representing a customer's home address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets a customer's address.
     *
     * @param address Sets the string representing the customer's address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Returns a customer's birthday.
     *
     * @return A LocalDate representing the customer's birthday.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets a customer's birthday.
     *
     * @param birthday Sets the string representing the customer's birthday.
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Returns a customer's phone number.
     *
     * @return A string representing the customer's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets a customer's phone number.
     *
     * @param phoneNumber Sets the string representing the customer's phone
     * number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a customer's ID.
     *
     * @return An Identifier representing the customer's ID.
     */
    public Identifier getId() {
        return id;
    }

    /**
     * Sets a customer's ID.
     *
     * @param id Sets the string representing the customer's ID.
     */
    public void setId(Identifier id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }
    
    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
    
    public void displayCustomer() {
        System.out.println("ID: " + getId());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Address: " + getAddress().toString());
        System.out.println("DOB : " + getBirthday());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Credit Score: " + getCredit() + "\n");
    }
    
    /**
     * Returns organized customer personal information.
     *
     * @return A string representing the street address of a customer.
     */
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s",
                this.firstName, this.lastName, this.address, this.birthday, this.phoneNumber);
    }
    
    public String getIDNameString() {
        return "ID: " + this.id + " | Full Name: " + this.firstName + " " + this.lastName;
    }
}
