package finalPractice7.problem02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnonymizedGeoData {
  private Map<Location, List<LocalDateTime>> anonyimizedGeoData;

  public AnonymizedGeoData(Map<Location, List<LocalDateTime>> anonyimizedGeoData){
    this.anonyimizedGeoData = anonyimizedGeoData;
  }

  public Map<Location, List<LocalDateTime>> getAnonyimizedGeoData() {
    return anonyimizedGeoData;
  }

  public Map<Location, List<LocalDateTime>> getAnonyimizedGeoData(List<User> users) {
    Map<Location, List<LocalDateTime>> data = new HashMap<>();
    if (users == null || users.size() == 0)
      return data;
    for (User user: users){
      for (GeoData geoData: user.getVisitedLocations()){
        Location location = new Location(geoData.getGeoLocation(), geoData.getGeoLocationXcoordinate(), geoData.getGetGeoLocationYcoordinate());
        data.putIfAbsent(location, new ArrayList<>());
        data.get(location).add(geoData.getTimeOfVisit());
      }
    }
    return data;
  }

}
