/*
 * Name: Ryan Carey
 * Email: ruc230@psu.edu
 * Course: IST 261
 * Assignment: IA01
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rint = new Random();
        /*
         * To get a random integer between 2 and 10, we get a random int
         * between 1 and 5 (inclusive), then double it.
         */
        ArrayList<Integer> guessMe = new ArrayList<>();    //Here I initialize the ArrayList. I opted not to import regular Lists and do it this way instead. one less thing.
        int currentGuess, tries = 0, correctGuesses = 0, high = 0, low = 9999999;
        String answer = "";
        System.out.println("Name: Ryan Carey");
        System.out.println("Email: ruc230@psu.edu");
        System.out.println("Course: IST 261");
        System.out.println("Assignment: IA01");
        do {
            currentGuess = -1;
            guessMe.add(2 * (rint.nextInt(5) + 1));
            if (guessMe.get(tries) > high)  //Here I replaced all instances of guessMe with guesses.get(tries) because the current index is equal to number of tries.
                high = guessMe.get(tries);
            if (guessMe.get(tries) < low)
                low = guessMe.get(tries);
            System.out.println(guessMe.get(tries));
            System.out.print("What is half of " + guessMe.get(tries) + "? ");

            while (currentGuess < 0) {
                try {
                    currentGuess = input.nextInt();
                }
                catch (InputMismatchException wrongInput) {
                    System.out.println("Invalid guess. Please enter a positive integer.");
                    input.nextLine();
                }
            }
            System.out.println("You answered: " + currentGuess);
            if (currentGuess == (guessMe.get(tries) / 2)) {
                System.out.println("Correct.");
                correctGuesses += 1;
            } else
                System.out.println("Incorrect.");
            tries += 1;
            System.out.print("Another Number? ");
            answer = input.next();
            while (!"N".equals(answer) && !"Y".equals(answer)) { //This while loop is new for IA02. Only Y or N will be accepted.
                System.out.println("Invalid input, please enter Y or N.");
                answer = input.next();
            }
        } while ("Y".equals(answer));
        System.out.println("Game over");
        System.out.println("You answered " + tries + " Questions.");
        System.out.println(correctGuesses + " were answered correctly.");
        System.out.println((tries - correctGuesses) + " were wrong.");
        System.out.println("You got " + (correctGuesses / tries * 100) + "% right.");
        System.out.println("The highest random number you were given was: " + high);
        System.out.println("The lowest random number you were given was: " + low);
        System.out.println("The list of numbers you were given: ");
        for (int number : guessMe)
            System.out.println(number);
    }
}
