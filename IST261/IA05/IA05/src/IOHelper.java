/*
 * Name: Ryan Carey
 * Email: ruc230@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */

import java.util.Scanner;

/**
 * A simple class that prompts the user and then takes input from the keyboard and can convert it to a double.
 *
 * @author Phil O'Connell (pxo4@psu.edu)
 */
public class IOHelper {
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Takes a string that serves as the prompt and gets user input from the keyboard.
     *
     * @param prompt - a string to output to the user, telling them what kind of data to enter.
     * @return the next line from the keyboard.
     */
    public static String userInputString(String prompt) {
        System.out.print(prompt + ": ");

        return keyboard.nextLine();
    }

    /**
     * A method to parse a passed string into a double.
     *
     * @param passedString - a string to be parsed to a double.
     * @return a double with the value of passedString, if possible.
     */
    public static double userInputDouble(String passedString) {
        Double outputDouble = null;

        while (outputDouble == null) {
            String userString = userInputString(passedString);
            outputDouble = ValidationHelper.tryParseDouble(userString);
        }

        return outputDouble;
    }

    /**
     * A method that prompts the user for keyboard input. If the first character of the input is one of the
     * acceptableChars, it gets returned. If not, the method will keep asking until a valid character is entered.
     *
     * @param prompt          - a string that tells the user what they should be entering.
     * @param acceptableChars - the range of characters that will be accepted.
     * @return a character from user input that matches one of the acceptableChars.
     */
    public static char userInputChar(String prompt, String acceptableChars) {

        char charToCheckFor = 0;
        while (!ValidationHelper.isCharInRange(charToCheckFor, acceptableChars)) {
            String inputString = userInputString(prompt + " (" + acceptableChars + ")");
            if (inputString.length() > 0) {
                charToCheckFor = inputString.charAt(0);
            }
        }

        return charToCheckFor;
    }
}
