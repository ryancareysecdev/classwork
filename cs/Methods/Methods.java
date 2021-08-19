//Ryan Carey
//Methods

import java.util.*;
import java.io.*;
public class Methods {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		double num1, num2;
		num1 = input.nextDouble();
		System.out.print("\nEnter the second number: ");
		num2 = input.nextDouble();
		System.out.printf("\nThe largest number is %14.2f\n", larger(num1, num2));
		System.out.printf("\nThe sum is            %14.2f\n", sum(num1, num2));
		System.out.printf("\nThe difference is     %14.2f\n", diff(num1, num2));
		System.out.printf("\nThe product is        %14.2f\n", prod(num1, num2));
		System.out.printf("\nThe quotient is       %14.2f\n", quot(num1, num2));
		System.out.printf("\nThe average is        %14.2f\n", avg(num1, num2));
	}
	public static double sum(double a, double b) {
		return a+b;
	}
	public static double diff(double a, double b) {
		double ans = Math.abs(a-b);
		return ans;
	}
	public static double prod(double a, double b) {
		return a*b;
	}
	public static double quot(double a, double b) {
		return a/b;
	}
	public static double larger(double a, double b) {
		double ans = Math.max(a,b);
		return ans;
	}
	public static double avg(double a, double b) {
		return (a+b)/2;
	}
}