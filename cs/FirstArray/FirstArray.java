//Ryan Carey
//FirstArray

import java.util.*;
import java.io.*;
public class FirstArray {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("how many numbers do u want to enter: ");
		int numbers = input.nextInt();
		int c = 0;
		double[] usr = new double[numbers];
		for(c = 0; c < numbers; c++) {
			System.out.print("enter a number: ");
			usr[c] = input.nextDouble();
		}
		System.out.println("your numbers are, in reverse: ");
		for(c = numbers-1; c >= 0; c--) {
			System.out.println(usr[c]);
		}
	}
}