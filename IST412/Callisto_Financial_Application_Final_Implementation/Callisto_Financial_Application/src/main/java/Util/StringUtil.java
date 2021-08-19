package Util;

/**
 * A class to check for null values or if a string contains white space or is
 * empty.
 */
public class StringUtil {

    /**
     * Checks if a string is null or empty.
     *
     * @param string String to check for null or empty value.
     * @return true if string is not null and is not empty.
     */
    public static boolean isNullOrEmpty(String string) {
        return (string == null) || (string.isEmpty());
    }

    /**
     * Checks if a string is null or contains white space..
     *
     * @param string String to check for null or white space value.
     * @return true if string is not null and does not contain white space.
     */
    public static boolean isNullOrWhitespace(String string) {
        return (string == null) || (string.trim().isEmpty());
    }

}
