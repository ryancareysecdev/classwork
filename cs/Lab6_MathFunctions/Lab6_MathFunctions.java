//Ryan Carey
//Lab6_MathFunctions - this lab is a simple example of using methods to organize a program in a way that makes sense

import java.util.*;
public class Lab6_MathFunctions
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double a = 0.0;   //this section initializes a scanner and some variables
		double b = 0.0;
		double c = 0.0;
		int menuChoice = -1;
		while (menuChoice != 0)
		{
			System.out.print("Enter 1 for the pythagorean theorem, 2 for the quadratic formula, 3 for the product, 4 for the average, and 0 to exit: ");
			menuChoice = input.nextInt();
			switch (menuChoice)  //This generates a menu traversible by entering digits based on prompts.
			{
				case 0: System.exit(1);
					break;
				case 1: System.out.print("Enter a side length: "); //each case handles prompts and stores resulting input in variables to pass to the method for that case.
               a = input.nextDouble();
               System.out.print("Enter another side length: ");
					b = input.nextDouble();
					pyth(a, b);
					break;
				case 2: System.out.print("Enter a: ");
               a = input.nextDouble();
               System.out.print("Enter b: ");
					b = input.nextDouble();
               System.out.print("Enter c: ");
					c = input.nextDouble();
					quad(a, b, c);
					break;
				case 3: System.out.print("Enter a number to multiply: ");
               a = input.nextDouble();
               System.out.print("Enter another number: ");
					b = input.nextDouble();
					prod(a, b);
					break;
				case 4: System.out.print("How many numbers would you like to average?: ");
               int numberofnums = input.nextInt();
               double[] passed = new double[numberofnums];
					for (int i = 0; i < passed.length; i++)
               {
                  System.out.print("Enter a number: ");
                  passed[i] = input.nextDouble(); 
               }
					avg(passed);
					break;
				default: prt("Please enter a valid menu option.");
				              break;
			}
		}
	}

	public static void prod(double a, double b)  //This method gives the product
	{
		prt("The product is: " + (a * b));
	}

	public static void avg(double[] a)  //this method gives the average of a specified number of numbers.
	{
      double avg = 0.0;
      for (int i = 0; i<a.length; i++)
      {
         avg += a[i];
      }
      avg = avg / a.length;
		prt("The average is: " + avg);
	}

	public static void pyth(double a, double b)  //this method will find the hypotenuse given a and b
	{
		prt("The hypotenuse is: " + Math.sqrt((a * a) + (b * b)));
	}

	public static void quad(double a, double b, double c) //this is an implementation of the quadratic formula
	{
	   double ans1 = 0.0;
	   double ans2 = 0.0;
	   if (breakcheck(a, b, c) == true)
	           prt("Nonreal answers sorry.");
		else
		{
	       ans1 = ((-1 * b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
	       ans2 = ((-1 * b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
			 prt("Valid input! For a = " + a + ", b = " + b + ", c = " + c);
	       prt("The answers are: " + ans1 + ", " + ans2);
	   }
	        
	}

	public static boolean breakcheck(double a, double b, double c)
	{
        	if (((b * b) - (4 * a * c)) < 0.0 | a == 0.0)
		   {
        		return true;
        	}
        	else
		   {
        		return false;
        	}
    }
    
    public static void prt(String s)
    {
      System.out.println(s);
    }
}