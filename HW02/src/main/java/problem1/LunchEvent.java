package problem1;

/**
 * The immutable class represents a lunch event. LunchEvent is a subclass of Event
 */
public class LunchEvent extends Event {
  private int numberOfSandwiches;
  private static final double CALCULATED_RATE_FOR_SANDWICHES = 1.05;
  private static final int MIN_ATTENDEES = 15;
  private static final int MAX_ATTENDEES = 90;

  /**
   * Constructs for LunchEvent class
   * @param clientName the client's name
   * @param numberOfPeople the number of people who will attend lunch event
   * @throws InvalidNumberException throw illegal argument exception
   */
  public LunchEvent(String clientName, int numberOfPeople)
      throws InvalidNumberException {
    super(clientName, numberOfPeople);
    if (this.isValidNumberOfPeople(numberOfPeople)){
      this.numberOfPeople = numberOfPeople;
    }else{
      throw new InvalidNumberException();
    }

    this.numberOfSandwiches = this.getNumberOfSandwiches();
  }

  /**
   * Helper method to check that the number of people who attend lunch event is valid
   * @param numberOfPeople  the number of people who attend lunch event
   * @return true if the number of people is valid, otherwise false
   */
  private boolean isValidNumberOfPeople(int numberOfPeople) {
    return numberOfPeople >= MIN_ATTENDEES && numberOfPeople <= MAX_ATTENDEES;
  }

  /**
   * Calculate the number of sandwiches
   * @return the number of sandwiches
   */
  public int getNumberOfSandwiches(){
    double sandwiches = CALCULATED_RATE_FOR_SANDWICHES * numberOfPeople;
    return (int)Math.round(sandwiches);
  }
}
