 /*
  * Name: Ryan Carey
  * Email: ruc230@psu.edu
  * Course: IST 261
  * Assignment: IA04
  */

 import java.util.*;

 enum Session {
     SPRING,
     SUMMER,
     FALL
 }

 /**
  * One section of a course
  * <p>
  * One course can have many sections.  This class represents one section for
  * one course.  The course is identified by its id.
  *
  * @author Phil O'Connell (pxo4@psu.edu)
  */
 public class CourseSection {
     /**
      * Uniquely identifies one section
      */
     private UUID id;

     public UUID getId() {
         return id;
     }

     /**
      * The course to which this section belongs
      */
     private Course course;

     public Course getCourse() {
         return course;
     }

     /**
      * Year this section is offered
      */
     private int year;

     /**
      * The semester in which this section is being offered
      * <p>
      * e.g., 1==Spring, 2==Fall, 3=Summer, etc...
      */
     private Session session;

     /**
      * The section number of the course
      * <p>
      * e.g., for IST123-001, "001" is the section
      */
     private String number;

     /**
      * The students who are registered for this section
      */
     private List<Student> students = new ArrayList<>();

     /**
      * Constructor for course section
      * <p>
      *
      * @param course  instance of a Course object
      * @param year    year the section is offered
      * @param session session this section is offered
      * @param number  section number
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public CourseSection(Course course, int year, Session session, String number) {
         this.id = UUID.randomUUID();
         this.course = course;
         this.year = year;
         this.session = session;
         this.number = number;

         students = new ArrayList<>();
     }

     /**
      * String representation of a course section
      *
      * @return string including subject, number, session, and year
      * @author Ryan Carey (ruc230@psu.edu)
      */
     @Override
     public String toString() {
         return course.getSubject() + course.getNumber() + "-" + this.number + " (" + this.session + " " + this.year + ")";
     }

     /**
      * Add a student to the section
      *
      * @param student a student enrolled in the section
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public void addStudent(Student student) {
         students.add(student);
     }

     /**
      * Count the number of students in the section.
      *
      * @return int the size of the student list
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public int getCount() {
         return students.size();

     }

     /**
      * Removes the given student from the section.
      *
      * @param student a student to be removed.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public void removeStudent(Student student) {
         students.remove(student);
     }

     /**
      * Removes the student with the given UUID
      *
      * @param studentId the UUID of the student to be removed.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public void removeStudent(UUID studentId) {
         for (Student student : students) {
             if (student.getId().equals(studentId)) {
                 students.remove(student);
                 return;
             }
         }
     }

     /**
      * Removes all students from the section.
      *
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public void removeAllStudents() {
         this.students.clear();
     }

     /**
      * Print the list of students
      * <p>
      * Assumes that Student class overrides toString();
      *
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public void printStudents() {
         for (Student s : this.students) {
             System.out.println(s);
         }
     }

     /**
      * finds a student by their UUID
      *
      * @param studentId the ID of the student being searched for
      * @return a student object with the given ID, if found.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public Student findStudent(UUID studentId) {
         for (Student enrolled : this.students) {
             if (enrolled.getId().equals(studentId)) {
                 return enrolled;
             }
         }
         return null;
     }

     /**
      * finds a student by their email. Written in the professor's style to make the code uniform.
      *
      * @param email the email of the student being searched for
      * @return the student with the given email, if found.
      * @author Ryan Carey (ruc230@psu.edu)
      */
     public Student findStudent(String email) {
         for (Student onTheRoster : this.students) {
             if (onTheRoster.getEmail().equals(email)) {
                 return onTheRoster;
             }
         }
         return null;
     }

     /**
      * finds a student by being passed the whole student object to search for
      *
      * @param student the student object to find in the section.
      * @return the specified student object, if found.
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public Student findStudent(Student student) {
         for (Student enrolled : this.students) {
             if (enrolled == student) {
                 return student;
             }
         }
         return null;
     }

     /**
      * Checks to see if the specified student is enrolled
      *
      * @param studentId the id of the student we're checking for.
      * @return a boolean answer to the query
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public boolean isStudentEnrolled(UUID studentId) {
         return (findStudent(studentId) != null);
     }

     /**
      * Checks to see if the specified student is enrolled
      *
      * @param student the student object we're checking for.
      * @return a boolean answer to the query
      * @author Phil O'Connell (pxo4@psu.edu)
      */
     public boolean isStudentEnrolled(Student student) {
         return (findStudent(student) != null);
     }

     /**
      * Checks to see if the specified student is enrolled. Written in the professor's style to keep the code clean.
      *
      * @param email the email of the student we're checking for.
      * @return a boolean answer to the query
      * @author Ryan Carey (ruc230@psu.edu)
      */
     public boolean isStudentEnrolled(String email) {
         //mine, in his style
         return (findStudent(email) != null);
     }

 }
