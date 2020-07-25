package problem01;

import java.util.ArrayList;

/**
 * An abstract class representing the information of artists
 */
public abstract class ArtistsBasicInfo implements ReceiveAward {
  protected Name name;
  protected int age;
  protected ArrayList<String> genres;
  protected ArrayList<String> awards;

  /**
   * Constructs for artist basic info class
   * @param name name
   * @param age age
   * @param genres genres
   * @param awards awards
   * @throws InvalidAgeException if age is invalid, throw an exception
   */
  public ArtistsBasicInfo(Name name, int age, ArrayList<String> genres, ArrayList<String> awards)
      throws InvalidAgeException{
    this.name = name;
    this.age = this.validAge(age);
    this.genres = genres;
    this.awards = awards;
  }

  /**
   * Check whether the age is valid or not
   * @param age age
   * @return age if it is valid, otherwise throw an exception
   * @throws InvalidAgeException if age is invalid, throw an exception
   */
  private int validAge(int age) throws InvalidAgeException{
    if (age >= 0 && age <= 128){
      return age;
    }else{
      throw new InvalidAgeException();
    }
  }

  /**
   * Get name
   * @return name
   */
  public Name getName(){
    return this.name;
  }

  /**
   * Get age
   * @return age
   */
  public int getAge(){
    return this.age;
  }

  /**
   * Get genres
   * @return a list of genres
   */
  public ArrayList<String> getGenres(){
    return this.genres;
  }

  /**
   * Get awards
   * @return a list of awards
   */
  public ArrayList<String> getAwards(){
    return this.awards;
  }

  /**
   * add awards
   * @param award  add awards
   * @return new list of awards
   */
  public ArrayList<String> artistReceivedAward(String award) {
    this.awards.add(award);
    return this.awards;
  }

}
