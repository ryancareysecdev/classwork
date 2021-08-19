package Model;

import Util.StringUtil;

/**
 * A class representing an employee.
 */
public class Employee extends Person{

    private String firstName;
    private String lastName;
    private Identifier id;

    /**
     * A constructor for creating an employee.
     *
     * @param firstName Employee first name.
     * @param lastName Employee last name.
     * @param middleName Employee middle name.
     * @param id Employee ID.
     */
    public Employee(String firstName, String lastName, Identifier id) {
        super(id, firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    /**
     * Returns an employee's first name.
     *
     * @return A string representing the employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets an employee's first name.
     *
     * @param firstName Sets the string representing the employee's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns an employee's last name.
     *
     * @return A string representing the employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets an employee's last name.
     *
     * @param lastName Sets the string representing the employee's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns an employee's ID.
     *
     * @return A string representing the employee's ID.
     */
    public Identifier getId() {
        return id;
    }

    /**
     * Sets an employee's ID.
     *
     * @param id Sets the string representing the employee's ID.
     */
    public void setId(Identifier id) {
        this.id = id;
    }

    /**
     * Returns an employee's name.
     *
     * @return String representing an employee's name.
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    /**
     * Returns organized customer personal information.
     *
     * @return A string representing the street address of a customer.
     */
    @Override
    public String toString() {
        return String.format("Employee ID: %s | Employee Full Name: %s %s",
                this.id, this.firstName, this.lastName);
    }
}
