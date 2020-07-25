package problem0102;

/**
 * This class represent a vehivle including ID, averageSpeed, maxSpeed
 */
public class Vehicle {
  private String ID;
  private Float averageSpeed;
  private Float maxSpeed;

  /**
   * @param ID ID
   * @param averageSpeed averageSpeed
   * @param maxSpeed maxSpeed
   */
  public Vehicle(String ID, Float averageSpeed, Float maxSpeed) {
    this.ID = ID;
    this.averageSpeed = averageSpeed;
    this.maxSpeed = maxSpeed;
  }

  /**
   * Get ID
   * @return ID
   */
  public String getID() {
    return ID;
  }

  /**
   * Get average speed
   * @return average speed
   */
  public Float getAverageSpeed() {
    return averageSpeed;
  }

  /**
   * Get max speed
   * @return max speed
   */
  public Float getMaxSpeed() {
    return maxSpeed;
  }
}
