 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA03
  */


 import org.junit.jupiter.api.Test;

 import static org.junit.jupiter.api.Assertions.assertTrue;

 /**
  * This is a test class to test the random integer generation method of the Util class. The assertions are performed 100 times each.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */
 public class UtilTest {


     /**
      * This is the method where the assertions are performed.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void generateRandomInt__Pass_2_10__Results_in_Range() {
         // Put your code here, then delete this comment line
         int randomEvenInt;
         for (int i = 0; i < 100; i++) {
             randomEvenInt = Util.generateRandomEvenInt(2, 10);
             assertTrue(randomEvenInt >= 2 && randomEvenInt <= 10);
             assertTrue(randomEvenInt % 2 == 0);
         }
     }
 }
