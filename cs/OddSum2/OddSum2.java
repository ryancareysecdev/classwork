//Ryan Carey
//OddSum2

import java.util.*;
public class OddSum2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long oddnum = 0, hval = 0, sum = 0;
		System.out.print("enter a number: ");
		hval = (long) input.nextDouble();		
		for (oddnum = 1; oddnum <= hval; oddnum += 2) {
			sum += oddnum;
		}
		System.out.print("the sum of the odd numbers is: "+sum);
	}
}