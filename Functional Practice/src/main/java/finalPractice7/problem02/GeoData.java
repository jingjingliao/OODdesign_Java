package finalPractice7.problem02;

import java.time.LocalDateTime;

public class GeoData {
  private String geoLocation;
  private Double geoLocationXcoordinate;
  private Double getGeoLocationYcoordinate;
  private LocalDateTime timeOfVisit;

  public GeoData(String geoLocation, Double geoLocationXcoordinate,
      Double getGeoLocationYcoordinate, LocalDateTime timeOfVisit) {
    this.geoLocation = geoLocation;
    this.geoLocationXcoordinate = geoLocationXcoordinate;
    this.getGeoLocationYcoordinate = getGeoLocationYcoordinate;
    this.timeOfVisit = timeOfVisit;
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

  public LocalDateTime getTimeOfVisit() {
    return timeOfVisit;
  }
}
