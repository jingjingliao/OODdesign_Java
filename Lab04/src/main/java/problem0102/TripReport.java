package problem0102;

import java.util.Objects;

/**
 * This class represent a trip report based on the vehicle, speed, distance and tripDuration
 */
public class TripReport {
  private Vehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer tripDuration;

  /**
   * @param vehicle vehicle
   * @param speed speed
   * @param distance distance
   * @param tripDuration tripDuration
   */
  public TripReport(Vehicle vehicle, Float speed, Float distance, Integer tripDuration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.tripDuration = tripDuration;
  }

  /**
   * Get vehicle
   * @return vehicle
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Get speed
   * @return speed
   */
  public Float getSpeed() {
    return speed;
  }

  /**
   * Get distance
   * @return distance
   */
  public Float getDistance() {
    return distance;
  }

  /**
   * Get trip duration time
   * @return trip duration time
   */
  public Integer getTripDuration() {
    return tripDuration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TripReport report = (TripReport) o;
    return Objects.equals(report.getVehicle(), getVehicle()) &&
        Float.compare(report.getSpeed(), getSpeed()) == 0 &&
        Float.compare(report.getDistance(), getDistance()) == 0 &&
        report.getTripDuration() == getTripDuration();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getVehicle(), getSpeed(), getDistance(), getTripDuration());
  }
}
