package problem0102;

/**
 * This class is mainly to produce the trip report
 */
public class FleetManager {

  public TripReport drive(Float distance, Vehicle vehicle) {
    return new TripReport(vehicle, vehicle.getAverageSpeed(), distance,
        (int) (distance / vehicle.getAverageSpeed()));
  }

  public TripReport drive(Float distance, Vehicle vehicle, Float speed) {
    if (speed > vehicle.getMaxSpeed()) {
      return new TripReport(vehicle, vehicle.getMaxSpeed(),
          distance, (int) (distance / vehicle.getMaxSpeed()));
    } else {
      return new TripReport(vehicle, speed,
          distance, (int) (distance / speed));
    }
  }

  public TripReport drive(Float speed, Vehicle vehicle, Integer tripDuration) {
    if (speed > vehicle.getMaxSpeed()) {
      return new TripReport(vehicle, vehicle.getMaxSpeed(),
          vehicle.getMaxSpeed() * tripDuration, tripDuration);
    } else {
      return new TripReport(vehicle, speed,
          speed * tripDuration, tripDuration);
    }
  }

}
