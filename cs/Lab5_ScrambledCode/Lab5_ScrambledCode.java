//-----------------------------------------------------------------------------
//	IST242, Spring 2018
//  Week 8 Assignment: Unscramble this Java code.
//
//  (Read the instructions that comes with the assignment)
//   Ryan Carey
//-----------------------------------------------------------------------------

import java.util.Arrays;
import java.util.Scanner;
public class Lab5_ScrambledCode
{
   final static int EXIT_VALUE=-1;//defines a way to exit the program
   public static void main(String[] args)
   {
		Scanner scan=new Scanner(System.in);
		int r,temp;
		int[] binaryVals=new int[100];
		int idx=0;
		int numDigits=0;
		int destBase=2;
		int numBits, i, numDisplayed;
		int inValue;
		
		for(i=0;i<100;i++)
			binaryVals[i]=0;
		inValue=-2;
		//-- The following while loop gets user input until a suitable value is received.
		
		while((inValue < 0 || inValue > 4000000) && (inValue != EXIT_VALUE))
		{
			System.out.print("Enter a decimal value betwee 0-4000000: ");
			inValue=scan.nextInt();
			
			if(( inValue < 0 ||inValue > 4000000) && inValue != EXIT_VALUE)
				System.out.println("You enter an invalid value !!!!");
		}
		temp=inValue;
		
		if(inValue!=EXIT_VALUE)
		{//-- This section only runs if inValue is not the exit value. This line determines whether the rest will run.
			
			while(temp!=0)
			{
				r=temp%destBase;    // the remainders are the conversion digits.
				temp=temp/destBase;
				binaryVals[idx]=r;
				idx++;
				numDigits++;
			} //-- This block does some basic math, recording the remainder of modular division in r and placing it in binaryVals, then incrementing the number of digits
			numBits=(((numDigits-1)/8)+1)*8;
			i = numBits - 1;
			numDisplayed = 0;
			System.out.print ("\n" + inValue + " = ");
			
			while(i >= 0)
			{
				System.out.print(binaryVals[i]+" ");
				numDisplayed++;
				i--;
			//-- This section prints the binary converted number back out to the console as two bytes separated by a dash.
				
				if(numDisplayed == 8 && i > 0)
				{
					System.out.print(" - ");
					numDisplayed=0;
				}
			}
		System.out.println("\n\n");
		}
   return;
   }
}

