/*
 * Name: Ryan Carey
 * Email: ruc230@psu.edu
 * Course: IST 261
 * Assignment: IA04
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger logger = LogManager.getRootLogger();

    public static void main(String[] args) {
        logger.info("IA05 has started");
        double operandOne = IOHelper.userInputDouble("Enter first numeric value");
        double operandTwo = IOHelper.userInputDouble("Enter second numeric value");
        char operation = IOHelper.userInputChar("Choose an operation", "+-*");

        double result;
        switch (operation) {
            case '+':
                result = MathHelper.addValues(operandOne, operandTwo);
                break;
            case '-':
                result = MathHelper.subtractValues(operandOne, operandTwo);
                break;
            case '*':
                result = MathHelper.multiplyValues(operandOne, operandTwo);
                break;
            default:
                System.out.println("Unrecognized operation!");
                return;
        }
        logger.debug(operandOne + " " + operation + " " + operandTwo + " = " + "result");
        System.out.println("The answer is " + result);
        logger.debug("IA05 has ended");
    }
}
