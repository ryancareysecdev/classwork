/*
 * Name: Ryan Carey
 * Email: ruc230@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A test class for use on the ValidationHelper.
 *
 * @author Ryan Carey (ruc230@psu.edu)
 */
public class ValidationHelperTest {

    /**
     * Assertion that the double value 1.2 will be accepted and returned by tryParseDouble.
     */
    @Test
    public void tryParseDouble__Pass_Pos_Dec__equals_explicit_double() {
        assertEquals((Double) 1.2, ValidationHelper.tryParseDouble("1.2"));
    }

    /**
     * Assertion that the value zero will be accepted and returned by tryParseDouble.
     */
    @Test
    public void tryParseDouble__Pass_Int_0__equals_explicit_double_zero() {
        assertEquals((Double) 0.0, ValidationHelper.tryParseDouble("0"));
    }

    /**
     * Assertion that the double value 0.0 will be accepted and returned by tryParseDouble.
     */
    @Test
    public void tryParseDouble__Pass_Double_Zero__equals_explicit_double_zero() {
        assertEquals((Double) 0.0, ValidationHelper.tryParseDouble("0.0"));
    }

    /**
     * Assertion that the double value -1 will be accepted and returned by tryParseDouble.
     */
    @Test
    public void tryParseDouble__Pass_Neg_Int__equals_explicit_neg_double() {
        assertEquals((Double) (-1.0), ValidationHelper.tryParseDouble("-1"));
    }

    /**
     * Assertion that the double value -1.2 will be accepted and returned by tryParseDouble.
     */
    @Test
    public void tryParseDouble__Pass_Neg_Dec__equals_explicit_neg_double() {
        assertEquals((Double) (-1.2), ValidationHelper.tryParseDouble("-1.2"));
    }

    /**
     * Assertion that passing an empty string to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Empty_String__returns_null() {
        assertNull(ValidationHelper.tryParseDouble(""));
    }

    /**
     * Assertion that passing a space to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Space__returns_null() {
        assertNull(ValidationHelper.tryParseDouble(" "));
    }

    /**
     * Assertion that passing two spaces to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Double_Space__returns_null() {
        assertNull(ValidationHelper.tryParseDouble("  "));
    }

    /**
     * Assertion that passing a string with too many decimal points to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Bad_Dec__returns_null() {
        assertNull(ValidationHelper.tryParseDouble("1.2.3"));
    }

    /**
     * Assertion that passing only a decimal point to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Dot__returns_null() {
        assertNull(ValidationHelper.tryParseDouble("."));
    }

    /**
     * Assertion that passing a non-numeric character to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Char__returns_null() {
        assertNull(ValidationHelper.tryParseDouble("x"));
    }

    /**
     * Assertion that passing a non-numeric string to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_Word__returns_null() {
        assertNull(ValidationHelper.tryParseDouble("one"));
    }

    /**
     * Assertion that passing a null to tryParseDouble will return a null.
     */
    @Test
    public void tryParseDouble__Pass_null__returns_null() {
        assertNull(ValidationHelper.tryParseDouble(null));
    }

    /**
     * Assertion that passing the first character in a string to isCharInRange along with that string will return true.
     */
    @Test
    public void isCharInRange__Pass_First_Char__returns_true() {
        assertTrue(ValidationHelper.isCharInRange('a', "abc"));
    }

    /**
     * Assertion that passing the second character in a string to isCharInRange along with that string will return true.
     */
    @Test
    public void isCharInRange__Pass_Second_Char__returns_true() {
        assertTrue(ValidationHelper.isCharInRange('b', "abc"));
    }

    /**
     * Assertion that passing the a character to isCharInRange along with that same character as a string will return true.
     */
    @Test
    public void isCharInRange__Pass_Same_Char_As_String__returns_true() {
        assertTrue(ValidationHelper.isCharInRange('a', "a"));
    }

    /**
     * Assertion that passing a space to isCharInRange along with that space as a string will return true.
     */
    @Test
    public void isCharInRange__Pass_Space_Char__returns_true() {
        assertTrue(ValidationHelper.isCharInRange(' ', " "));
    }

    /**
     * Assertion that passing a character to isCharInRange along with an empty string will return false.
     */
    @Test
    public void isCharInRange__Pass_Char_To_Empty__returns_false() {
        assertFalse(ValidationHelper.isCharInRange('a', ""));
    }

    /**
     * Assertion that passing a character to isCharInRange along with a string that doesn't contain that character will return false.
     */
    @Test
    public void isCharInRange__Pass_Char_To_Different_String__returns_false() {
        assertFalse(ValidationHelper.isCharInRange('b', "xyz"));
    }

    /**
     * Assertion that passing a character to isCharInRange along with a null will return false.
     */
    @Test
    public void isCharInRange__Pass_Char_To_Null__returns_false() {
        assertFalse(ValidationHelper.isCharInRange('a', null));
    }

    /**
     * Assertion that passing a character to isCharInRange along with a space string will return false.
     */
    @Test
    public void isCharInRange__Pass_Char_To_Space__returns_false() {
        assertFalse(ValidationHelper.isCharInRange('z', " "));
    }

}