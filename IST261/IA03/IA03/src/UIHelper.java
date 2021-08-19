 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA03
  */

 import java.util.Scanner;


 /**
  * A helper class with user input methods to make the main program more readable. It references a third class,
  * ValidationHelper, for the actual validation of that user input.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */
 public class UIHelper {
     private static Scanner keyboard = new Scanner(System.in);

     /**
      * @param prompt -  A string to be printed to the console in order to ask the user for a specific choice of responses.
      * @return userInput - A string that can only be "Y" or "N".
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public String readYN(String prompt) {
         String userInput;


         while (true) {
             System.out.print(prompt);
             userInput = keyboard.nextLine();
             if (!ValidationHelper.isValidYorN(userInput)) {
                 System.out.println();
                 System.out.println("You must enter Y or N");
             } else {
                 break;
             }
         }

         return userInput;

     }

     /**
      * @param prompt -  A string to be printed to the console in order to ask the user for a specific choice of responses.
      * @return userIntAnswer - A positive integer.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public int readPositiveInt(String prompt) {
         int userIntAnswer = 0;

         boolean validInt;
         do {
             validInt = true;

             System.out.print(prompt);
             String userInput = keyboard.nextLine();
             System.out.println("You answered: " + userInput);

             if (ValidationHelper.isPositiveInt(userInput)) {
                 userIntAnswer = Integer.parseInt(userInput);
             } else {
                 validInt = false;
             }

             if (!validInt) {
                 System.out.println("You must enter a positive number with no decimals");
             }
         } while (!validInt);

         return userIntAnswer;

     }
 }
