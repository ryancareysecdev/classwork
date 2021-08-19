//Ryan Carey
//Chuck

import java.util.*;
public class Chuck {
	public static void delay(int microseconds) throws InterruptedException {
		Thread.sleep(microseconds);
	}
	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		int highest = 0, val = 0, seconds = 0;
		System.out.print("Time delay in microseconds: ");
		seconds = input.nextInt();
		System.out.print("enter a number: ");
		highest = input.nextInt();		
		for (val = highest; val > 0; val--) {
			System.out.print(val+"\t");
			delay(seconds);
		}
	}
}