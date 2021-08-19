 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA04
  */

 import org.junit.Before;
 import org.junit.BeforeClass;
 import org.junit.Test;

 import static org.junit.Assert.*;


 public class CourseSectionTest {
     private static Course testCourse;
     private static CourseSection testSection;

     private static Student homer = new Student("Homer Simpson", "hjs5123@psu.edu");
     private static Student marge = new Student("Marge Simpson", "mxs5456@psu.edu");
     private static Student bart = new Student("Bart Simpson", "bxs5321@psu.edu");

     @BeforeClass
     /**
      * This will run one time -- before all the tests
      */
     public static void setUp() {
         System.out.println("One-time setup");

         testCourse = new Course("IST", 261, "Application Development Design Studio I");
         testSection = new CourseSection(testCourse, 2019, Session.FALL, "001");
     }

     @Before
     /**
      * This will run before each test
      */
     public void setUpEach() {
         initSection();
     }


     private void initSection() {
         testSection.removeAllStudents();

         testSection.addStudent(homer);
         testSection.addStudent(marge);
         testSection.addStudent(bart);
     }

     @Test
     public void isStudentEnrolled__Add_New_Student__Then_Is_Enrolled_In_Section() {
         // Remove this line after you write the test
         Student lisa = new Student("Lisa Simpson", "Lisa.Sim@psu.edu");
         testSection.addStudent(lisa);
         assertTrue(testSection.findStudent(lisa) == lisa);
         // Create a new student object
         // Add that student to the section
         // Write an assert that ensures the student is enrolled
     }

     @Test
     public void isStudentEnrolled__Pass_Email__Then_Is_Enrolled_In_Section() {
         // DON'T EDIT THIS TEST
         // You need to finish writing CourseSection.isStudentEnrolled that takes an email address
         assertTrue(testSection.isStudentEnrolled(homer.getEmail()));
     }

     @Test
     public void isStudentEnrolled__Pass_Student_Object__Then_Is_Enrolled_In_Section() {
         // Remove this line after you write the test
         assertTrue(testSection.isStudentEnrolled(homer));

         // Write an assert to ensure that you can find a student when you pass their instance object
     }

     @Test
     public void isStudentEnrolled__Pass_Student_ID__Then_Is_Enrolled_In_Section() {
         // Remove this line after you write the test
         assertTrue(testSection.isStudentEnrolled(homer.getId()));

         // Write an assert to ensure that you can find a student when you pass their ID
     }

     @Test
     public void isStudentEnrolled__Remove_All_Students__Then_None_Enrolled() {
         // Remove this line after you write the test
         testSection.removeAllStudents();
         assertFalse(testSection.isStudentEnrolled(homer));
         assertFalse(testSection.isStudentEnrolled(marge));
         assertFalse(testSection.isStudentEnrolled(bart));


         // Call one method to remove all the students
         // Write 3 asserts to ensure that each student is not enrolled
     }

     @Test
     public void isStudentEnrolled__Remove_Student__Then_Not_Enrolled() {
         // Remove this line after you write the test
         testSection.removeStudent(homer);
         assertFalse(testSection.isStudentEnrolled(homer));

         // Remove a student from the section
         // Write an assert to ensure that student is not found in the course
     }

     @Test
     public void findStudent__Pass_Existing_Student_Email__Found_In_Section() {
         // DO NOT EDIT THIS TEST!
         // You need to finish writing CourseSection.isStudentEnrolled that takes an email address
         assertSame(homer, testSection.findStudent("hjs5123@psu.edu"));
     }

     @Test
     public void findStudent__Pass_Existing_Student_ID__Found_In_Section() {
         // Remove this line after you write the test
         testSection.isStudentEnrolled(homer.getId());

         // Write an assert to ensure you can find a student via a student ID
         // 3 students were already created in @BeforeClass
         // Do NOT create a student object here
     }

     @Test
     public void findStudent__Pass_Existing_Student_Obj__Found_In_Section() {
         // Remove this line after you write the test
         testSection.isStudentEnrolled(homer);

         // Write an assert to ensure you can find a student via a student object
         // 3 students were already created in @BeforeClass
         // Do NOT create a student object here
     }

     @Test
     public void removeAllStudents__Remove_All__Count_Becomes_Zero() {
         // Remove this line after you write the test
         testSection.removeAllStudents();
         assertEquals(testSection.getCount(), 0);

         // Remove all the students from the section
         // Write an assert to ensure the count is now zero
     }

     @Test
     public void getCount__No_Action__Count_Is_Three() {
         // Remove this line after you write the test
         assertEquals(testSection.getCount(), 3);

         // The section is already initialized
         // Write an assert to ensure there the count is 3
     }

     @Test
     public void toString__Create_Course_Section__String_Is_Correct() {
         // DO NOT EDIT THIS TEST!
         // You need to finish writing CourseSection.toString()
         assertEquals("IST261-001 (FALL 2019)", testSection.toString());
     }
 }
