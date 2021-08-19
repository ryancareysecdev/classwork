 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA03
  */

 /**
  * A class that checks whether an input string is "Y" or "N" in one method, and checks whether an input string is a positive integer in another.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */
 public class ValidationHelper {
     /**
      * A method which takes an input string and checks whether it is equal to "Y" or "N". If it is equal to either, it returns true.
      * Any other case returns false.
      *
      * @param str - a string to be validated as either "Y" or "N"
      * @return true or false, depending whether the input string was valid.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public static boolean isValidYorN(String str) {
         if ("Y".equals(str) || "N".equals(str)) {
             return true;
         }

         return false;
     }

     /**
      * A method which takes an input string and checks whether it is a positive integer. If it is a positive integer, it returns true.
      * If it's not, it returns false.
      *
      * @param str - a string to be validated as a positive integer
      * @return true or false, depending whether the input string is a positive integer.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public static boolean isPositiveInt(String str) {
         boolean success = true;

         try {
             int parsedInt = Integer.parseInt(str);
             if (parsedInt <= 0) {
                 success = false;
             }
         } catch (Exception e) {
             success = false;
         }

         return success;
     }
 }
