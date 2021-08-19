package Model;

public class Person {
    private String firstName;
    private String lastName;
    private Identifier id;
    
    public Person (Identifier id, String firstName, String lastName)
    {
        this.id = id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Identifier getID() {
        return id;
    }

    public void setID(Identifier id) {
        this.id = id;
    }
}
