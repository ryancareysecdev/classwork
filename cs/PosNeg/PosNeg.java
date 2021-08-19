//Ryan Carey
//PosNeg

import java.util.*;
import java.io.*;
public class PosNeg {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("how many numbers do you want to enter: ");
		int numbers = input.nextInt();
		int c = 0, neg = 0, pos = 0;
		double[] usr = new double[numbers];
		double[] pa = new double[numbers];
		double[] na = new double[numbers];
		double sum = 0, psum = 0, nsum = 0, low = 1e60, high = -1e60;
		for(c = 0; c < numbers; c++) {
			System.out.print("enter a number: ");
			usr[c] = input.nextDouble();
			System.out.println();
			if (usr[c] < 0) {
				na[neg] = usr[c];
				neg++;
				nsum += usr[c];
			}
			if (usr[c] > 0) {
				pa[pos] = usr[c];
				pos++;
				psum += usr[c];
			}
			if (usr[c] < low)
				low = usr[c];
			if (usr[c] > high)
				high = usr[c];
			sum += usr[c];
		}
		System.out.println("\nthere are " + pos + " positive numbers\n");
		System.out.println("the positive numbers are: \n");
		for(c = 0; c < numbers; c++) {
			if (pa[c] != 0)
				System.out.println(pa[c]);
		}
		System.out.println("there are " + neg + " negative numbers\n");
		System.out.println("the negative numbers are: \n");
		for(c = 0; c < numbers; c++) {
			if (na[c] != 0)
				System.out.println(na[c]);
		}
		System.out.println("\nthe lowest number is: " + low + "\n");
		System.out.println("the highest number is: " + high + "\n");
		System.out.println("the average is " + sum / numbers + "\n");
		System.out.println("the average of positive numbers is: " + psum / pos + "\n");
		System.out.println("the sum of negative numbers is: " + nsum / neg + "\n");
	}
}