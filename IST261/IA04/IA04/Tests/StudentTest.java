 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA04
  */

 import org.junit.Test;

 import static org.junit.Assert.*;

 public class StudentTest {

     /*
      * DO NOT EDIT THIS TEST!!
      * Resolve this problem by creating the appropriate Student.toString() method
      */
     @Test
     public void toString__Pass_Student__String_Is_Correct() {
         Student lisa = new Student("Lisa Simpson", "lxs5321@psu.edu");
         assertEquals("Lisa Simpson (lxs5321@psu.edu)", lisa.toString());
     }
 }
