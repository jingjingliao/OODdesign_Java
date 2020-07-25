package problem1;

/**
 * An immutable class represents an event by given client name and number of people
 */
public class Event {
  public String clientName;
  public int numberOfPeople;

  /**
   * Constructs for an event class
   * @param clientName - client name
   * @param numberOfPeople - the number of people who will attend the event
   */
  public Event(String clientName, int numberOfPeople){
    this.clientName = clientName;
    this.numberOfPeople = numberOfPeople;
  }

  /**
   * Get the client name
   * @return client name
   */
  public String getClientName(){
    return this.clientName;
  }

  /**
   * Get the number of people who attend the event
   * @return the number of people
   */
  public int getNumberOfPeople(){
    return this.numberOfPeople;
  }

}
