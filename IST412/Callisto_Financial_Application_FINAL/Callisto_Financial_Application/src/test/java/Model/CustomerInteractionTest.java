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
 *  
 */
public class CustomerInteractionTest {
    Identifier id = new Identifier();
    RandomGenerator randomGenerator = new RandomGenerator();
    Address address = new Address("123 Main St", "Philly", "PA", "12345");
    Customer customer = new Customer(id, "Donald", "Trump", address, "02-21-1960", "123-456-7890", randomGenerator.generateCredit());
    LoanRequest loan = new LoanRequest(id, customer, LoanRequest.LoanType.PERSONAL, LoanRequest.LoanStatus.ACCEPTED, 3000, 2000);
    
    public CustomerInteractionTest() {
    }

    /**
     * Test of requestLoan method, of class FinancialProfile.
     */
    @Test
    public void testRequestLoan() throws InterruptedException {
        System.out.println("requestLoan");
        LoanRequest.LoanType loanType = loan.getLoanType();
        double loanAmount = loan.getAmount();
        CustomerInteraction instance = new CustomerInteraction();
        LoanRequest expResult = instance.requestLoan(customer, loanType.PERSONAL, 3000);
        LoanRequest result = instance.requestLoan(customer, loanType, loanAmount);
        assertEquals(expResult, result);
        System.out.println(result);
        System.out.println(expResult);
    }
    
}

