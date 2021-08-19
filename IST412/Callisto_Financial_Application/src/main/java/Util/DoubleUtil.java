package Util;

/**
 * A class to parse a string to return a double.
 */
public class DoubleUtil {

    /**
     * Tries to parse a string into a double.
     *
     * @param text String to be parsed into a double.
     * @return A double parsed from a string.
     */
    public static Double tryParseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (Exception e) {
            return null;
        }
    }

}
