/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alban
 */
public class CredentialCheckTest {
    
    public CredentialCheckTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of verifyCredentials method, of class CredentialCheck.
     */
    @Test
    public void testVerifyCredentials__valid_entry__login_passes() {
        System.out.println("verifyCredentials - valid login");
        String username = "EmployeeOne";
        String password = "employee1";
        CredentialCheck instance = new CredentialCheck();
        boolean expResult = true;
        boolean result = instance.verifyCredentials(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testVerifyCredentials__invalid_entry__login_fails() {
        System.out.println("verifyCredentials - Invalid login");
        String username = "employee0";
        String password = "farfignewton";
        CredentialCheck instance = new CredentialCheck();
        boolean expResult = false;
        boolean result = instance.verifyCredentials(username, password);
        assertEquals(expResult, result);

    }
}
