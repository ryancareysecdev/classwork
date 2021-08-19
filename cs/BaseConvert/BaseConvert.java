//Ryan Carey
//BaseConvert

import java.util.*;
public class BaseConvert {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int base, num, choice=0;
		while (choice!=1) {
			System.out.print("Enter the number you want to convert: ");
			num=inputN();
			System.out.print("Enter the base you want to convert to: ");
			base=inputN();
			if (num!=0 && base>1 && base<38) {
				for (int i=2; i<37; i++) {
					if (i<=num) {
						if (i==base) {
							System.out.println("This is your number: "+Integer.toString(num, i));
						}
						else {
							System.out.println(Integer.toString(num, i));
						}
					}
				}
			}
			else {
				if (num==0 || base==0) {
					System.out.println("You typed invalid characters!");
				}
				else {
					System.out.println("That base is too high or too low!");
				}
			}
		System.out.print("Would you like to enter any other numbers? Enter \"1\" to exit: ");
		choice=inputN();
		}
	}
	public static int inputN() {
		int n=0, choice=1;
		try {
			n = input.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("It must be an Integer!");
		}
		finally {
			return n;
		}
	}
	
}