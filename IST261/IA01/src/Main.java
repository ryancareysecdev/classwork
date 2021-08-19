/*
 * Name: Ryan Carey
 * Email: ruc230@psu.edu
 * Course: IST 261
 * Assignment: IA01
 */
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rint = new Random();
        /*
         * To get a random integer between 2 and 10, we get a random int
         * between 1 and 5 (inclusive), then double it.
         */

        int guessme = 0, currentGuess = 0, tries = 0, correctGuesses = 0, high = 0, low = 0;
        String answer;
        System.out.println("Name: Ryan Carey");
        System.out.println("Email: ruc230@psu.edu");
        System.out.println("Course: IST 261");
        System.out.println("Assignment: IA01");
        do {
            guessme = 2 * (rint.nextInt(5) + 1);
            if (guessme > high)
                high = guessme;
            if (guessme < low)
                low = guessme;
            System.out.println(guessme);
            System.out.print("What is half of " + guessme + "? ");
            currentGuess = input.nextInt();
            System.out.println("You answered: " + currentGuess);
            if (currentGuess == (guessme / 2)) {
                System.out.println("Correct.");
                correctGuesses += 1;
            } else
                System.out.println("Incorrect.");
            tries += 1;
            System.out.print("Another Number? ");
            answer = input.next();

        }
        while (!answer.equals("N"));
        System.out.println("Game over");
        System.out.println("You answered " + tries + " uestions.");
        System.out.println(correctGuesses + " were answered correctly.");
        System.out.println((tries - correctGuesses) + " were wrong.");
        System.out.println("You got " + (correctGuesses / tries * 100) + "% right.");
        System.out.println("The highest random number you were given was: " + high);
        System.out.println("The lowest random number you were given was: " + low);
    }
}
