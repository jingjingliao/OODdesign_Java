package problem1;

/**
 * Runner contains information about a runner, including runner's name, height, weight, league
 * the best 5k time, the best half marathon time and the favourite running event
 */
public class Runner extends Athlete{
  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favouriteRunningEvent;

  /**
   * Constructs a new runner, based upon all of the provided input parameters
   * @param athletesName - object name, containing runner's first, middle and last name
   * @param height - runner's height, expressed as a Double in cm
   * @param weight - runner's weigh, expressed as a Double in pounds (e.g. 125, 155 pounds)
   * @param league - runner's league, expressed as String
   * @param best5KTime - runner's best 5k time
   * @param bestHalfMarathonTime - runner's best half marathon time
   * @param favouriteRunningEvent - runner's favourite running event
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double bestHalfMarathonTime, String favouriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favouriteRunningEvent = favouriteRunningEvent;
  }

  /**
   * Constructs a new runner, based upon all of the provided input parameters
   * @param athletesName - object name, containing runner's first, middle and last name
   * @param height - runner's height, expressed as a Double in cm
   * @param weight - runner's weigh, expressed as a Double in pounds (e.g. 125, 155 pounds)
   * @param best5KTime - runner's best 5k time
   * @param bestHalfMarathonTime - runner's best half marathon time
   * @param favouriteRunningEvent - runner's favourite running event
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5KTime,
      Double bestHalfMarathonTime, String favouriteRunningEvent){
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favouriteRunningEvent = favouriteRunningEvent;
  }

  /**
   * @return runner's best 5k time
   */
  public Double getBest5KTime(){
    return this.best5KTime;
  }

  /**
   * @return runner's best half marathon time
   */
  public Double getBestHalfMarathonTime(){
    return this.bestHalfMarathonTime;
  }

  /**
   * @return runner's favourite running event
   */
  public String getFavouriteRunningEvent(){
    return this.favouriteRunningEvent;
  }

}
