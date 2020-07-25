package problem01;

import java.util.ArrayList;

/**
 * An immutable class representing the information of poem
 */
public class Poem extends ArtistsBasicInfo {
  private String publishingCompany;
  private String lastPublishedCollection;

  /**
   * Constructs for poem class
   * @param name name
   * @param age age
   * @param genres genres
   * @param awards awards
   * @param publishingCompany  publishingCompany
   * @param lastPublishedCollection lastPublishedCollection
   * @throws InvalidAgeException if age is invalid, throw an exception
   */
  public Poem(Name name, int age, ArrayList<String> genres,
      ArrayList<String> awards, String publishingCompany, String lastPublishedCollection)
      throws InvalidAgeException {
    super(name, age, genres, awards);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  /**
   * Get publishing company
   * @return  publishing company
   */
  public String getPublishingCompany() {
    return publishingCompany;
  }

  /**
   * Get last published collection
   * @return last published collection
   */
  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }
}
