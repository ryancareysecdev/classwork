/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alban
 */
public class AddressTest {
    Address address = new Address("123 Main St", "Philly", "PA", "12345");
    public AddressTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getStreet method, of class Address.
     */
   @Test
    public void testGetStreet() {
        System.out.println("getStreet");
//        Address instance = new Address ("123 Main St", "Penn State", "PA", 2021);
        String expResult = "123 Main St";
        String result = address.getStreet();
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        
       
    }

    /**
     * Test of setStreet method, of class Address.
     */
//    @Test
//    public void testSetStreet() {
//        System.out.println("setStreet");
//        String street = "";
//        Address instance = null;
//        instance.setStreet(street);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getCity method, of class Address.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = "Philly";
        String result = address.getCity();
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setCity method, of class Address.
     */
//    @Test
//    public void testSetCity() {
//        System.out.println("setCity");
//        String city = "";
//        Address instance = null;
//        instance.setCity(city);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getState method, of class Address.
     */
     @Test
    public void testGetState() {
        System.out.println("getState");
        String expResult = "PA";
        String result = address.getState();
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setState method, of class Address.
     */
//    @Test
//    public void testSetState() {
//        System.out.println("setState");
//        String state = "";
//        Address instance = null;
//        instance.setState(state);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getZip method, of class Address.
     */
     @Test
    public void testGetZip() {
        System.out.println("getZip");
        String expResult = "12345";
        String result = address.getZip();
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setZip method, of class Address.
     */
//    @Test
//    public void testSetZip() {
//        System.out.println("setZip");
//        int zip = 12345;
//        Address instance = null;
//        instance.setZip(zip);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class Address.
     */
     @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "123 Main St, Philly, PA, 12345";
        String result = address.toString();
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
    }
    
}
