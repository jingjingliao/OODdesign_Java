package problem1;

/**
 * BaseballPlayer contains information about an Baseball Player, including Baseball Player's name,
 * their height, weight, league, team, averageBatting and seasonHomeRuns
 *
 */
public class BaseballPlayer extends Athlete {
  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  /**
   * Constructs a new Baseball Player, based upon all of the provided input parameters
   * @param athletesName - object name, containing player's first, middle and last name
   * @param height - player's height, expressed as a Double in cm
   * @param weight - player's weigh, expressed as a Double in pounds (e.g. 125, 155 pounds)
   * @param league - player's league, expressed as String
   * @param team -  player's team, expressed as String
   * @param averageBatting - player's averageBatting, expressed as Double
   * @param seasonHomeRuns - player's seasonHomeRuns, expressed as Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Constructs a new Baseball Player, based upon all of the provided input parameters
   * @param athletesName - object name, containing player's first, middle and last name
   * @param height - player's height, expressed as a Double in cm
   * @param weight - player's weigh, expressed as a Double in pounds (e.g. 125, 155 pounds)
   * @param team -  player's team, expressed as String
   * @param averageBatting - player's averageBatting, expressed as Double
   * @param seasonHomeRuns - player's seasonHomeRuns, expressed as Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight,
      String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * @return player's team
   */
  public String getTeam(){
    return this.team;
  }

  /**
   * @return player's averageBatting
   */
  public Double getAverageBatting(){
    return this.averageBatting;
  }

  /**
   * @return player's seasonHomeRuns
   */
  public Integer getSeasonHomeRuns(){
    return this.seasonHomeRuns;
  }

}
