//Ryan Carey
//Sum

import java.util.*;
import java.io.*;
public class Sum {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner num = new Scanner(new File("Numbers.txt"));
		int howMany = 0, i = 0;
		howMany = num.nextInt();
		double high = -1.0, low = 100.0, current = 0, sum = 0;
		for(i = 1; i <= howMany; i++) {
			current = num.nextDouble();
			if (current < low)
				low = current;
			if (current > high)
				high = current;
			sum += current;
		}
		System.out.println("there are " + howMany + " numbers");
		System.out.println("the sum is " + sum);
		System.out.println("the average is " + sum / howMany);
		System.out.println("the highest number is " + high);
		System.out.println("the lowest number is " + low);
	}
}