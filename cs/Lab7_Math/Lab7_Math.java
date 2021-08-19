package Lab7_Math;
//Ryan Carey
//Lab7_Math - this lab is a simple example of using methods to organize a program in a way that makes sense, without a main method
import java.util.*;
public class Lab7_Math
{
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