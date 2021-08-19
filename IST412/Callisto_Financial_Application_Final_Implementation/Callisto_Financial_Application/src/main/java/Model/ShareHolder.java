package Model;

public class ShareHolder extends Person{

    private String firstName;
    private String lastName;
    private Identifier id;

    public ShareHolder(String firstName, String lastName, Identifier id) {
        super(id, firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
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

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }
    
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
