package problem1;

/**
 * Class problem1.Athlete contains information about an athlete, including athlete's name,
 * their height, weight and league.
 */

public class Athlete {

  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName - object problem1.Name, containing athlete's first, middle and last
   * name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is
   * recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155,
   * 200 pounds)
   * @param league - league - athelete's league, expressed as String
   */

  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName - object problem1.Name, containing athlete's first, middle and last
   * name
   * @param height - athlete's height, expressed as a Double in cm (e.g., 6'2'' is
   * recorded as 187.96cm)
   * @param weight - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155,
   * 200 pounds)
   */

  public Athlete(Name athletesName, Double height, Double weight){
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * @return athlete's name as an object problem1.Name
   */
  public Name getAthletesName() {
    return athletesName; }

  /**
   * @return athlete's height as a Double
   */
  public Double getHeight() {
    return height; }

  /**
   * @return athlete's weight as a Double
   */
  public Double getWeight() {
    return weight; }

  /**
   * @return athlete's league as a String
   */
  public String getLeague() {
    return league; }

}



