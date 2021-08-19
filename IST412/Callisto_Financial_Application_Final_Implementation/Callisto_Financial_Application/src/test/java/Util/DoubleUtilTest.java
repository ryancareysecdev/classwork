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
public class DoubleUtilTest {
    
    public DoubleUtilTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of tryParseDouble method, of class DoubleUtil.
     */
    @Test
    public void testTryParseDouble() {
        System.out.println("tryParseDouble");
        String text = "400.50";
        Double expResult = 400.50;
        Double result = DoubleUtil.tryParseDouble(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
