//Ryan Carey, AutoUsageMain class utilizing instantiation to keep track of separate vehicles if need be.
package Lab8_AutoUsage;
import java.util.*;
public class AutoUsageMain 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		double milesDriven = 0.0;   //this section initializes a scanner and some variables
		double gasAdded = 0.0;
      double spentOnGas = 0.0;
		int menuChoice = -1;
      AutoUsage myCar = new AutoUsage();
		while (true)
		{
			System.out.print("Enter 1 to add miles, 2 to add gas, 3 for the current MPG, and 4 to exit: ");
			menuChoice = input.nextInt();
			switch (menuChoice)  //This generates a menu traversible by entering digits based on prompts.
			{
				case 1: System.out.print("How many miles did you drive?: "); //
               milesDriven = input.nextDouble();
               myCar.AddMiles(milesDriven);
					break;
				case 2: System.out.print("How many gallons did you add?: ");
               gasAdded = input.nextDouble();
               System.out.print("How much did it cost?: ");
               spentOnGas = input.nextDouble();
					myCar.AddGas(gasAdded, spentOnGas);
					break;
				case 3: System.out.println("You are currently getting " + myCar.Calc_MPG() + " MPG and have spent a total of: $" + myCar.SpentOnGas());
					break;
				case 4: System.exit(1);
					break;
				default: break;
			}
		}
	}
}