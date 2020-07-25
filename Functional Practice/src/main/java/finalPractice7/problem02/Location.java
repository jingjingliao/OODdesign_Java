package finalPractice7.problem02;

public class Location {
  private String geoLocation;
  private Double geoLocationXcoordinate;
  private Double getGeoLocationYcoordinate;

  public Location(String geoLocation, Double geoLocationXcoordinate,
      Double getGeoLocationYcoordinate) {
    this.geoLocation = geoLocation;
    this.geoLocationXcoordinate = geoLocationXcoordinate;
    this.getGeoLocationYcoordinate = getGeoLocationYcoordinate;
  }

  public String getGeoLocation() {
    return geoLocation;
  }

  public Double getGeoLocationXcoordinate() {
    return geoLocationXcoordinate;
  }

  public Double getGetGeoLocationYcoordinate() {
    return getGeoLocationYcoordinate;
  }

  @Override
  public String toString() {
    return "Location{" +
        "geoLocation='" + geoLocation + '\'' +
        ", geoLocationXcoordinate=" + geoLocationXcoordinate +
        ", getGeoLocationYcoordinate=" + getGeoLocationYcoordinate +
        '}';
  }
}
