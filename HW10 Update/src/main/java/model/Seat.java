package model;

import java.util.Objects;

/**
 * Seat class
 */
public class Seat {
  private String seatName;
  private String reserveFor;

  /**
   * Coonstructs a seat
   * @param seatName seatName
   * @throws InvalidSeatName if seat name is invalid
   */
  public Seat(String seatName) throws InvalidSeatName {
    this.reserveFor = null;
    this.seatName = isValidSeatName(seatName);
  }

  /**
   * Check whether the seat name is valid or not
   * @param seatName seatName
   * @return valid seat name
   * @throws InvalidSeatName if seat name is invalid
   */
  private String isValidSeatName(String seatName) throws InvalidSeatName {
    if (!seatName.matches("[A-Z]*") || !this.upperCaseLetter(seatName))
      throw new InvalidSeatName("Seat name should be the capital letter from A to Z");
    else
      return seatName;
  }

  /**
   * Check whether the seat name is all upper case
   * @param seatName seatName
   * @return true if they are all upper case
   */
  private boolean upperCaseLetter(String seatName){
    for(char c : seatName.toCharArray()) {
      if(! Character.isUpperCase(c))
        return false;
    }
    return true;
  }

  /**
   * Get seat name
   * @return seat name
   */
  public String getSeatName() {
    return seatName;
  }

  /**
   * Get reserved for
   * @return reserved for
   */
  public String getReserveFor() {
    return reserveFor;
  }

  /**
   * Set the seats are reserved for
   * @param reserveFor reserved for
   */
  public void setReserveFor(String reserveFor) {
    this.reserveFor = reserveFor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Seat seat = (Seat) o;
    return Objects.equals(getSeatName(), seat.getSeatName()) &&
        Objects.equals(getReserveFor(), seat.getReserveFor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSeatName(), getReserveFor());
  }

  @Override
  public String toString() {
    return "Seat{" +
        "seatName='" + seatName + '\'' +
        ", reserveFor='" + reserveFor + '\'' +
        '}';
  }
}
