package p1;

import java.util.List;
import java.util.stream.Collectors;

public class TravelerIterator {
  private List<Traveler> travelers;
  private int current;
  private static final int TRAVEL_AT_LEAST_FIVE_TIMES = 5;
  private static final Float TRAVEL_AT_LEAST_200_MILES_FROM_SEATTLE = 200F;

  public TravelerIterator(List<Traveler> travelers){
    this.travelers = this.filterTraveller(travelers);
    this.current = 0;
  }

  public List<Traveler> filterTraveller(List<Traveler> travelers){
    return travelers.stream().filter(traveler -> traveler.traveledDestinations().size() >= TRAVEL_AT_LEAST_FIVE_TIMES).filter(traveler -> this.filterDistance(traveler.traveledDestinations())).collect(
        Collectors.toList());
  }

  private Boolean filterDistance (List<Destination> traveledDestinations){
    if (traveledDestinations == null || traveledDestinations.size() == 0)
      return false;
    for (Destination des: traveledDestinations){
      if (des.getDistanceFromSeattle() >= TRAVEL_AT_LEAST_200_MILES_FROM_SEATTLE)
        return true;
    }
    return false;
  }
}
