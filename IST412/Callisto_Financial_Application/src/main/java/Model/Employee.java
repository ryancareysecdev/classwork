package Model;

import Util.StringUtil;

/**
 * A class representing an employee.
 */
public class Employee extends Person{

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
       super (firstName, lastName);
        this.id = id;
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
        return String.format("%s|%s|%s",
                this.id, this.getFirstName(), this.getLastName());
    }

}
