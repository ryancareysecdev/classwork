/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Util.RandomGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author david
 */
public class CustomerTest {
    
    Identifier id = new Identifier();
    RandomGenerator randomGenerator = new RandomGenerator();
    Address address = new Address("123 Main St", "Philly", "PA", "12345");
    Customer customer = new Customer(id, "Donald", "Trump", address, "02-21-1960", "123-456-7890", randomGenerator.generateCredit());
    
    public CustomerTest() {
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Donald";
        String result = customer.getFirstName();
        assertEquals(expResult, result);
    }
    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Trump";
        String result = customer.getLastName();
        assertEquals(expResult, result);
    }
    /**
     * Test of getAddress method, of class Customer.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        String expResult = "123 Main St, Philly, PA, 12345";
        String result = customer.getAddress().toString();
        assertEquals(expResult, result);
    }
    /**
     * Test of getBirthday method, of class Customer.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        String expResult = "02-21-1960";
        String result = customer.getBirthday();
        assertEquals(expResult, result);
    }
    /**
     * Test of getPhoneNumber method, of class Customer.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        String expResult = "123-456-7890";
        String result = customer.getPhoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Customer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Identifier expResult = id;
        Identifier result = customer.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Donald|Trump|123 Main St, Philly, PA, 12345|02-21-1960|123-456-7890";
        String result = customer.toString();
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
    }
    
}
