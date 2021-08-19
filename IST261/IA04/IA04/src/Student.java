 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA04
  */

 import java.util.UUID;

 /**
  * This class represents a PSU student
  * <p>
  * We don't have many fields in this class.  Its purpose is just to represent a
  * small portion of the data of an actual PSU student.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */

 public class Student {
     private UUID id;

     /**
      * Gets the id of the student
      *
      * @return student id
      */
     public UUID getId() {
         return id;
     }

     private String name;

     /**
      * Gets the name of the student
      *
      * @return The name of the student
      */
     public String getName() {
         return name;
     }

     /**
      * Gets the email address of the student
      *
      * @return The email address of the student
      */
     public String getEmail() {
         return email;
     }

     private String email;

     public String toString() {
         return (name + " (" + email + ")");
     }

     public Student(String name, String email) {
         this.id = UUID.randomUUID();
         this.name = name;
         this.email = email;
     }


 }
