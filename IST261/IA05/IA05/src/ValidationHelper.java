/*
 * Name: Ryan Carey
 * Email: ruc230@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A class with methods to parse user input into a double, and search for a character in a string.
 *
 * @author Phil O'Connell (pxo4@psu.edu)
 */
public class ValidationHelper {
    private static final Logger logger = LogManager.getRootLogger();

    /**
     * Attempts to parse a double with the built in method of that Object. If an exception occurs, it is logged and null is returned.
     *
     * @param userInput A string that this method will attempt to parse as a double.
     * @return The parsed double, or null if an exception occurs.
     */
    public static Double tryParseDouble(String userInput) {
        try {
            return Double.parseDouble(userInput);
        } catch (Exception e) {
            logger.debug("Invalid input: " + userInput);
            return null;
        }
    }

    /**
     * A method that searches for a passed character within a passed string.
     *
     * @param charToFind - A character to search for in range.
     * @param range      - A string to search through.
     * @return a boolean that indicates whether or not charToFind is in range.
     */
    public static boolean isCharInRange(char charToFind, String range) {
        if (range == null) {
            return false;
        }
        return (range.indexOf(charToFind) >= 0);
    }
}
