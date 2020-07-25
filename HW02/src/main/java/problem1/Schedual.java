package problem1;

/**
 * The class represents a schedual for lunch event and dinner event
 */
public class Schedual {
  private LunchEvent lunchEvent;
  private DinnerEvent dinnerEvent;

  /**
   * Constructs for Schedual class. Inialize lunch event and dinner event as null
   * @param lunchEvent lunch event
   * @param dinnerEvent dinner event
   */
  public Schedual(LunchEvent lunchEvent, DinnerEvent dinnerEvent){
    this.lunchEvent = null;
    this.dinnerEvent = null;
  }

  /**
   * Get the lunch event
   * @return lunch event
   */
  public LunchEvent getLunchEvent(){
    return this.lunchEvent;
  }

  /**
   * Get the dinner event
   * @return dinner event
   */
  public DinnerEvent getDinnerEvent(){
    return this.dinnerEvent;
  }

  /**
   * Book the lunch event
   * @param lunchEvent1 book lunch event in schedual
   */
  public void bookingLunchEvent(LunchEvent lunchEvent1) {
    if (this.lunchEvent == null){
      this.lunchEvent = lunchEvent1;
      }
    }

  /**
   * Book the dinner event
   * @param dinnerEvent1 book dinner event in schedual
   */
  public void bookingDinnerEvent(DinnerEvent dinnerEvent1){
    if (this.dinnerEvent == null){
      this.dinnerEvent = dinnerEvent1;
    }
  }

}
