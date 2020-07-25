package p3;

import java.util.List;
import java.util.Objects;

/**
 * Class represents a traveler. The traveler has a first name, last name and a
 * list of destinations they visited in the last year.
 */
public class Traveler {
  private String firstName;
  private String lastName;
  private List<Destination> traveledDestinations;


  /**
   * Constructs a Traveler object and initializes it
   * to the given first name, last name and the list of traveled destinations
   * @param firstName the first name of this person
   * @param lastName the last name of this person
   * @param traveledDestinations list of destinations they visited in the last year.
   */

  public Traveler(String firstName, String lastName, List<Destination> traveledDestinations) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.traveledDestinations = traveledDestinations;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<Destination> traveledDestinations() {
    return traveledDestinations;
  }


}