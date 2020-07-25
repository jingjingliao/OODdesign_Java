package problem1;

/**
 * The immutable class represents a dinner event. DinnerEvent is a subclass of Event
 */
public class DinnerEvent extends Event{
  private int nonVegetarian;
  private int vegetarian;
  private static final int MIN_ATTENDEES = 10;
  private static final int MAX_ATTENDEES = 50;
  private static final double CALCULATED_RATE_FOR_NON_VEGETARIAN = 0.8;
  private static final double CALCULATED_RATE_FOR_VEGETARIAN = 0.2;

  /**
   * Constructs for DinnerEvent class
   * @param clientName  the client's name
   * @param numberOfPeople the number of people who will attend dinner event
   * @throws InvalidNumberException throw illegal argument exception
   */
  public DinnerEvent(String clientName, int numberOfPeople) throws InvalidNumberException {
    super(clientName, numberOfPeople);

    if (this.isValidNumberOfPeople(numberOfPeople)){
      this.numberOfPeople = numberOfPeople;
    }else{
      throw new InvalidNumberException();
    }

    this.nonVegetarian = this.getNonVegetarian();
    this.vegetarian = this.getVegetarian();
  }

  /**
   * Helper method to check that the number of people who attend dinner event is valid
   * @param numberOfPeople the number of people who attend dinner event
   * @return true if the number of people is valid, otherwise false
   */
  private boolean isValidNumberOfPeople(int numberOfPeople) {
    return numberOfPeople >= MIN_ATTENDEES && numberOfPeople <= MAX_ATTENDEES;
  }

  /**
   * Calculate the number of non-vegetarian food
   * @return the number of non-vegetarian food
   */
  public int getNonVegetarian(){
    double nonVegetarian = CALCULATED_RATE_FOR_NON_VEGETARIAN * numberOfPeople;
    return (int)Math.round(nonVegetarian);
  }

  /**
   * Calculate the number of vegetarian food
   * @return the number of vegetarian food
   */
  public int getVegetarian(){
    double vegetarian = CALCULATED_RATE_FOR_VEGETARIAN * numberOfPeople;
    return (int)Math.round(vegetarian);
  }

}
