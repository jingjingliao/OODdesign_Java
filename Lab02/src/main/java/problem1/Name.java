package problem1;

/**
 * Name contains information about a name
 * including a person's first name, middle name and last name
 */

public class Name {
  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructs a new name, based upon all of the provided input parameters
   * @param firstName first name
   * @param middleName  middle name
   * @param lastName last name
   */
  public Name(String firstName, String middleName, String lastName){
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * @return the first name
   */
  public String getFirstName(){
    return this.firstName;
  }

  /**
   * @return the middle name
   */
  public String getMiddleName(){
    return this.middleName;
  }

  /**
   * @return the last name
   */
  public String getLastName(){
    return this.lastName;
  }

  /**
   * @param firstName set new first name
   */
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }

  /**
   * @param middleName set new middle name
   */
  public void setMiddleName(String middleName){
    this.middleName = middleName;
  }

  /**
   * @param lastName set new last name
   */
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
}

