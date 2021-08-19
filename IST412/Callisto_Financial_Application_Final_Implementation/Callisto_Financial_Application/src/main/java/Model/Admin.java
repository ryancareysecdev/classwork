package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Admin {

    private String firstName;
    private String lastName;
    private static final Admin INSTANCE = new Admin();
    private List<Admin> adminList;
    
    public Admin(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    private Admin() {
        this.adminList = Collections.synchronizedList(new ArrayList<>());
    }
    
    public List getAllAdmins() {
        adminList.add(new Admin("Admin", "One"));
        adminList.add(new Admin("Admin", "Two"));
        adminList.add(new Admin("Admin", "Three"));
        return adminList;
    }
    
    public static Admin getInstance() {
        return INSTANCE;
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
}
