/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alban
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class LoanHistoryTest {
    
    private LoanHistory loanHistory = new Model.LoanHistory.getInstance();
    Customer customer1 = new Customer(new Identifier(), "Customer", "One", new Address("123 Main St", "Philly", "PA", "12345"), "02-12-1992", "967-623-2347", 700);
    
    public LoanHistoryTest() {
    }

    /**
     * Test of getInstance method, of class LoanHistory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        LoanHistory expResult = loanHistory;
        LoanHistory result = LoanHistory.getInstance();
        assertEquals(expResult, result);
    }

    /**
     /* Test of add method, of class LoanHistory.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        LoanRequest loan = new LoanRequest(new Identifier(), customer1, LoanRequest.LoanType.PERSONAL, LoanRequest.LoanStatus.ACCEPTED, 3000, 2000);
        LoanHistory instance = loanHistory;
        instance.add(loan);
        assertEquals(loanHistory, instance);
    }

    /**

import Model.Identifier;
import Model.LoanRequest;

     * Test of getAll method, of class LoanHistory.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        LoanHistory instance = null;
        List<LoanRequest> expResult = null;
        List<LoanRequest> result = instance.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class LoanHistory.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        LoanHistory instance = null;
        instance.clear();
    }
    
}
