//Ryan Carey
//PosNegSum

import java.util.*;
public class PosNegSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numbers = 0, pos = 0, neg = 0, entered = 0, cntr = 0;
		System.out.print("how many terms do you want to enter?: ");
		numbers = input.nextInt();
		for (cntr = 0; numbers > cntr; cntr++) {
			System.out.print("enter a positive or negative number: ");
			entered = input.nextInt();
			if (entered > 0) {
				pos += entered;
			}
			else {
				neg += entered;
			}
		}
		System.out.println("the sum of positive numbers is: " +pos);
		System.out.println("the sum of negative numbers is: " +neg);
	}
}