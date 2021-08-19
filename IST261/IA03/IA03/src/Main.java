 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA03
  */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Collections;

 /**
  * The main class, where it becomes clear this is a simple math game. The game asks the user what half of a random
  * number between 2 and 10 is. The number of tries, number of correct answers, and number of incorrect answers are recorded.
  * Later they are output back to the user at the conclusion of the game.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */
 public class Main {

     /**
      * The main method, where the main program executes. The program outputs some basic info, then begins the math game.
      * The user is asked to answer what half of a given random integer between 2 and 10 is
      * using uiHelper.readPositiveInt, which in turn validates the input using
      * ValidationHelper.isPositiveInt
      * The random integer is also appended to an ArrayList of Integers for output.
      * The number of attempts, correct answers, and incorrect answers are all also stored in variables so they can be
      * output to the console at the end of the game.
      *
      * @param args - a string array of console arguments that aren't used in this program.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public static void main(String[] args) {
         System.out.println("Name: Ryan Carey");
         System.out.println("Email: ruc230@psu.edu");
         System.out.println("Course: IST 261");
         System.out.println("Assignment: IA03");
         System.out.println();

         String userInput = "Y";
         int count = 0;
         int correct = 0;
         int incorrect = 0;

         List<Integer> randomInts = new ArrayList<>();

         UIHelper uiHelper = new UIHelper();
         while (userInput.equals("Y")) {
             count++;
             int randomInt = Util.generateRandomEvenInt(2, 10);
             randomInts.add(randomInt);

             int userIntAnswer = uiHelper.readPositiveInt("What is half of " + randomInt + "? ");

             if (userIntAnswer == (randomInt / 2)) {
                 System.out.println("Correct!");
                 correct++;
             } else {
                 System.out.println("Wrong!");
                 incorrect++;
             }

             userInput = uiHelper.readYN("Another number (Y/N)? ");
             System.out.println();
         }

         System.out.println("Game over");
         System.out.println("You answered " + count + " questions");
         System.out.println(correct + " were right");
         System.out.println(incorrect + " were wrong");
         System.out.println("You got " + (100 * correct / count) + "% right");
         System.out.println("The highest random number you were given:  " + Collections.max(randomInts));
         System.out.println("The lowest random number you were given:  " + Collections.min(randomInts));
         System.out.println("The list of numbers you were given:");
         for (int randomInt : randomInts) {
             System.out.println(randomInt);
         }
     }
 }
