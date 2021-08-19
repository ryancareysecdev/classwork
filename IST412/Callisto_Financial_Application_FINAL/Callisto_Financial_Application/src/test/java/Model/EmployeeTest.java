/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author david
 */
public class EmployeeTest {
    
    Identifier id = new Identifier();
    
    Employee employee = new Employee("Employee", "One", id);
    
    public EmployeeTest() {
    }

    /**
     * Test of getFirstName method, of class Employee.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Employee";
        String result = employee.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Employee.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "One";
        String result = employee.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Employee.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Identifier expResult = id;
        Identifier result = employee.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of fullName method, of class Employee.
     */
    @Test
    public void testFullName() {
        System.out.println("fullName");
        String expResult = "Employee One";
        String result = employee.getFullName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Employee.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = id + "|Employee|One" ;
        String result = employee.toString();
        assertEquals(expResult, result);
    }
    
}
