package finalPractice05.problem04;

import java.util.Objects;

public class Destination {
  private String destinationName;
  private String country;
  private String airportCode;
  private Float distanceFromSeattle;

  public Destination(String destinationName, String country, String airportCode,
      Float distanceFromSeattle) {
    this.destinationName = destinationName;
    this.country = country;
    this.airportCode = airportCode;
    this.distanceFromSeattle = distanceFromSeattle;
  }

  public String getDestinationName() {
    return destinationName;
  }

  public void setDestinationName(String destinationName) {
    this.destinationName = destinationName;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getAirportCode() {
    return airportCode;
  }

  public void setAirportCode(String airportCode) {
    this.airportCode = airportCode;
  }

  public Float getDistanceFromSeattle() {
    return distanceFromSeattle;
  }

  public void setDistanceFromSeattle(Float distanceFromSeattle) {
    this.distanceFromSeattle = distanceFromSeattle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false; Destination that = (Destination) o;
    return Objects.equals(destinationName, that.destinationName) &&
        Objects.equals(country, that.country) &&
        Objects.equals(airportCode, that.airportCode) &&
        Objects.equals(distanceFromSeattle, that.distanceFromSeattle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destinationName, country, airportCode, distanceFromSeattle);
  }

  @Override
  public String toString() {
    return "Destination{" +
        "destinationName='" + destinationName + '\'' +
        ", country='" + country + '\'' +
        ", airportCode='" + airportCode + '\'' +
        ", distanceFromSeattle=" + distanceFromSeattle +
        '}';
  }
}
