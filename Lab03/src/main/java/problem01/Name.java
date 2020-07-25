package problem01;

/**
 * An immutable class representing the name
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Construct a name
   * @param firstName first name
   * @param lastName last name
   */
  public Name(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Get first name
   * @return first name
   */
  public String getFirstName(){
    return this.firstName;
  }

  /**
   * Get last name
   * @return  last name
   */
  public String getLastName(){
    return this.lastName;
  }
}
