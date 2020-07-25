package problem02;

import java.util.Objects;

public class Vehicle {
  private String make;
  private String model;
  private Integer year;
  private String vehicleColor;

  private Vehicle(String make, String model, Integer year, String vehicleColor){
    this.make = make;
    this.model = model;
    this.year = year;
    this.vehicleColor = vehicleColor;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public Integer getYear() {
    return year;
  }

  public String getVehicleColor() {
    return vehicleColor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Vehicle))
      return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(getMake(), vehicle.getMake());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMake()); }

  @Override
  public String toString() {
    return "Vehicle{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", vehicleColor=" + vehicleColor +
        '}';
  }
}
