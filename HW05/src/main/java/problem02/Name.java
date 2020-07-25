package problem02;

/**
 * Name class
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Construct a name with first name and last name
   * @param firstName first name
   * @param lastName last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get first name
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get last name
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }
}
