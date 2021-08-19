/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.LoanRequest.LoanStatus.ACCEPTED;
import static Model.LoanRequest.LoanType.PERSONAL;
import Util.RandomGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alban
 */
public class LoanRequestTest {
    
    RandomGenerator randomGenerator = new RandomGenerator();
    
    Address address = new Address("123 Main St", "Philly", "PA", "12345");
    Customer customer = new Customer(new Identifier(), "Donald", "Trump", address, "02-21-1960", "123-456-7890", randomGenerator.generateCredit());
    LoanRequest loan = new LoanRequest(new Identifier(), customer, LoanRequest.LoanType.PERSONAL, LoanRequest.LoanStatus.ACCEPTED, 3000, 2000);

    public LoanRequestTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of getId method, of class LoanRequest.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Identifier result = loan.getId();
        Identifier expResult = loan.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
         System.out.println(result);
        System.out.println(expResult);
    }

    /**
     * Test of getLoanType method, of class LoanRequest.
     */
    @Test
    public void testGetLoanType() {
        System.out.println("getLoanType");
       
        LoanRequest.LoanType expResult = PERSONAL;
        LoanRequest.LoanType result = loan.getLoanType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        System.out.println(result);
        System.out.println(expResult);
    }

    /**
     * Test of getLoanStatus method, of class LoanRequest.
     */
    @Test
    public void testGetLoanStatus() {
        System.out.println("getLoanStatus");
      
        LoanRequest.LoanStatus expResult = ACCEPTED;
        LoanRequest.LoanStatus result = loan.getLoanStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
          System.out.println(result);
        System.out.println(expResult);
    }

    /**
     * Test of setId method, of class LoanRequest.
     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        Identifier id = null;
//        LoanRequest instance = null;
//        instance.setId(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setDateTimeCreated method, of class LoanRequest.
     */
//    @Test
//    public void testSetDateTimeCreated() {
//        System.out.println("setDateTimeCreated");
//        LocalDateTime dateTimeCreated = null;
//        LoanRequest instance = null;
//        instance.setDateTimeCreated(dateTimeCreated);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDateTimeCreated method, of class LoanRequest.
     */
//    @Test
//    public void testGetDateTimeCreated() {
//        System.out.println("getDateTimeCreated");
//        LoanRequest instance = null;
//        LocalDateTime expResult = null;
//        LocalDateTime result = instance.getDateTimeCreated();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getAmount method, of class LoanRequest.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        
        double expResult = 3000;
        double result = loan.getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println(result);
        System.out.println(expResult);
    }

    /**
     * Test of setAmount method, of class LoanRequest.
     */
//    @Test
//    public void testSetAmount() {
//        System.out.println("setAmount");
//        String loanAmount = "";
//        LoanRequest instance = null;
//        instance.setAmount(loanAmount);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of toString method, of class LoanRequest.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "id,PERSONAL, PENDING, 5000";
        String result = loan.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
         System.out.println(result);
        System.out.println(expResult);
    }
    
}