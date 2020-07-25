package problem01;

import java.util.ArrayList;

/**
 * An immutable class representing the information of Painter and Photographer
 */
public class PainterPhotographer extends ArtistsBasicInfo {
  private ArrayList<String> exhibits;

  /**
   * Constructs for Painter and Photographer class
   * @param name name
   * @param age age
   * @param genres genres
   * @param awards awards
   * @param exhibits exhibits
   * @throws InvalidAgeException if age is invalid, throw an exception
   */
  public PainterPhotographer(Name name, int age, ArrayList<String> genres,
      ArrayList<String> awards, ArrayList<String> exhibits) throws InvalidAgeException {
    super(name, age, genres, awards);
    this.exhibits = exhibits;
  }

  /**
   * Get exhibits
   * @return a list of exhibits
   */
  public ArrayList<String> getExhibits() {
    return this.exhibits;
  }

}
