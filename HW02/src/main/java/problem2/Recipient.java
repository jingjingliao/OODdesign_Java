package problem2;

/**
 * An immutable class representing a recipient which includes first name,
 * last name and email of the recipient
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Constructs a recipient
   * @param firstName the first name of this recipient
   * @param lastName the last name of this recipient
   * @param email the email of this recipient
   */
  public Recipient(String firstName, String lastName, String email){
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Get the first name of the recipient
   * @return the first name of the recipient
   */
  public String getFirstName(){
    return this.firstName;
  }

  /**
   * Get the last name of the recipient
   * @return the last name of the recipient
   */
  public String getLastName(){
    return this.lastName;
  }

  /**
   * Get the email of the recipient
   * @return the email of the recipient
   */
  public String getEmail(){
    return this.email;
  }
}
