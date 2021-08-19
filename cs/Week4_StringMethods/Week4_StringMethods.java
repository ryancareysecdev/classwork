//Ryan Carey
//StringMethods
//ryan Carey basic string manip
import java.util.*;
public class Week4_StringMethods
{
	public static void main(String[] args)
   {
		Scanner gimme = new Scanner(System.in);
      String firstString="", secondString="";
      while (firstString == "" || firstString.length()>50)
      {
      System.out.print("Enter a string: ");
      firstString = gimme.nextLine();
      }
      while (secondString == "" || secondString.length()>50)
      {
      System.out.print("Another string please: ");
      secondString = gimme.nextLine();
      }
		System.out.println("charAt 2: " + firstString.charAt(2));
      System.out.println("compareTo: " + firstString.compareTo(secondString));
      System.out.println("endsWith: " + firstString.endsWith("a"));
      System.out.println("indexOf: " + firstString.indexOf("a"));
      System.out.println("length: " + firstString.length());
      System.out.println("substring: " + firstString.substring(0, firstString.length()));
      System.out.println("toLowercase: " + firstString.toLowerCase());

      
	}
}