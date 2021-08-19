 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA03
  */

 import org.junit.jupiter.api.Test;

 import static org.junit.jupiter.api.Assertions.*;

 /**
  * A test class that checks proper responses by the input validator to a multitude of different keyboard inputs.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */
 public class ValidationHelperTest {

     /*
      * Tests for isValidYorN
      */

     /**
      * A method that tests whether the expected response "Y" returns true when passed to the "Y or N" validator, as it should.
      *
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     @Test
     public void isValidYorN__Pass_Y__Returns_True() {
         assertTrue(ValidationHelper.isValidYorN("Y"));
     }

//TODO: My code starts here, javadoc

     /**
      * A method that tests whether the expected response "N" returns true when passed to the "Y or N" validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isValidYorN__Pass_N__Returns_True() {
         assertTrue(ValidationHelper.isValidYorN("N"));
     }

     /**
      * A method that tests whether the unexpected response "Yes" returns false when passed to the "Y or N" validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isValidYorN__Pass_Yes__Returns_False() {
         assertFalse(ValidationHelper.isValidYorN("Yes"));
     }

     /**
      * A method that tests whether the unexpected response "z" returns false when passed to the "Y or N" validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isValidYorN__Pass_z__Returns_False() {
         assertFalse(ValidationHelper.isValidYorN("z"));
     }

     /**
      * A method that tests whether the unexpected response " " returns false when passed to the "Y or N" validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isValidYorN__Pass_space__Returns_False() {
         assertFalse(ValidationHelper.isValidYorN(" "));
     }

     /**
      * A method that tests whether the unexpected response "" returns false when passed to the "Y or N" validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isValidYorN__Pass_empty_string__Returns_False() {
         assertFalse(ValidationHelper.isValidYorN(""));
     }


     /*
      * Tests for isPositiveInt
      */

     /**
      * A method that tests whether "0" returns false when passed to the positive int validator, as it should.
      *
      * @author @author Phil O'Connell (pxo4@psu.edu)
      */
     @Test
     public void isPositiveInt__Pass_0__Returns_False() {
         assertFalse(ValidationHelper.isPositiveInt("0"));
     }

     //TODO: Javadoc this section. my code starts here.

     /**
      * A method that tests whether "-1" returns false when passed to the positive int validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isPositiveInt__Pass_neg_1__Returns_False() {
         assertFalse(ValidationHelper.isPositiveInt("-1"));
     }

     /**
      * A method that tests whether "1" returns true when passed to the positive int validator, as it should.
      *
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Test
     public void isPositiveInt__Pass_pos_1__Returns_True() {
         assertTrue(ValidationHelper.isPositiveInt("1"));
     }

 }
