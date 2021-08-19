import java.util.UUID;

/**
 * Represents one PSU course
 * <p>
 * One course can have 0 or more sections
 */
public class Course
{
  /**
   * Uniquely identifies a course
   */
  private UUID id;
  public UUID getId() {
    return id;
  }

  /**
   * The name of the course
   */
  private String name;
  public String getName() {
    return name;
  }

  /**
   * The subject, according to Lionpath
   * <p>
   * LionPath calls "IST" the "subject", so we'll use that here.
   */
  private String subject;
  public String getSubject() {
    return subject;
  }

  /**
   * The section number of the course
   * <p>
   * e.g., for IST123-001, 123 is the number
   */
  private int number;
  public int getNumber() {
    return number;
  }

  /**
   * Constructor for the course
   *
   * @param subject course subject (e.g., "IST")
   * @param number  number of the course (e.g., "123")
   * @param name    name of the course (e.g., "Java Programming")
   */
  public Course(String subject, int number, String name) {
    this.id = UUID.randomUUID();
    this.subject = subject;
    this.number = number;
    this.name = name;
  }
}
