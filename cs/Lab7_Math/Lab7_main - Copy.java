import java.util.*;
public class Lab7_Main
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double a = 0.0;   //this section initializes a scanner and some variables
		double b = 0.0;
		double c = 0.0;
		int menuChoice = -1;
		Lab7_Main otherFile = new Lab7_Main();
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
					otherFile.pyth(a, b);
					break;
				case 2: System.out.print("Enter a: ");
               a = input.nextDouble();
               System.out.print("Enter b: ");
					b = input.nextDouble();
               System.out.print("Enter c: ");
					c = input.nextDouble();
					otherFile.quad(a, b, c);
					break;
				case 3: System.out.print("Enter a number to multiply: ");
               a = input.nextDouble();
               System.out.print("Enter another number: ");
					b = input.nextDouble();
					otherFile.prod(a, b);
					break;
				case 4: System.out.print("How many numbers would you like to average?: ");
               int numberofnums = input.nextInt();
               double[] passed = new double[numberofnums];
					for (int i = 0; i < passed.length; i++)
               {
                  System.out.print("Enter a number: ");
                  passed[i] = input.nextDouble(); 
               }
					otherFile.avg(passed);
					break;
				default: otherFile.otherFile.prt("Please enter a valid menu option.");
				              break;
			}
		}
	}
}