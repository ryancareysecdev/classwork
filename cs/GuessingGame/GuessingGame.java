//Ryan Carey
//GuessingGame

import java.util.*;
import java.io.*;
public class GuessingGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rint = new Random();
		int highest = 0, ran = 0, guess = 0, tries = 0, last = 0;
		System.out.println("this is ryan carey's guessing game!");
		System.out.print("enter the highest number allowed: ");
		highest = input.nextInt();
		ran = rint.nextInt(highest)+1;
		while (true) {
			System.out.print("enter your guess: ");
			last = guess;
			guess = input.nextInt();
			if (guess < 1 || guess > highest)
				System.out.println("its between 1 and your number moron!");
			if (guess > ran) {
				System.out.println("too high!");
				tries++;
				if (guess > last && last > ran)
					System.out.println("you are getting colder!!!");
			}
			if (guess < ran) {
				System.out.println("too low!");
				tries++;
				if (guess < last && last < ran)
					System.out.println("you are getting colder!!!");
			}
			if (guess == ran) {
				break;
			}
		}
		tries++;
		System.out.println("you guessed it!!! good job!");
		System.out.println("it took you "+tries+" tries.");
	}
}