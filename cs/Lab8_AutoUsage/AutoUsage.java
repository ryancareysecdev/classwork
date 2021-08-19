//Ryan Carey, AutoUsage base class
package Lab8_AutoUsage;
public class AutoUsage
{
   double totalMiles, totalGallons, totalGasMoney;
   public AutoUsage()
   {
      totalMiles = 0.0;
      totalGallons = 0.0;
      totalGasMoney = 0.0;
   }
   
   public void AddMiles(double newMiles)
   {
      totalMiles += newMiles;
   }
   
   public void AddGas(double newGallons, double moneySpent)
   {
      totalGallons += newGallons;
      totalGasMoney += moneySpent;
   }
   
   public double Calc_MPG()
   {
      return (totalMiles / totalGallons);
   }
   
   public double SpentOnGas()
   {
      return totalGasMoney;
   }
}