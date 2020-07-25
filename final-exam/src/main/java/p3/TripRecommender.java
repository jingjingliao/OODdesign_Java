package p3;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import sun.security.krb5.internal.crypto.Des;

public class TripRecommender {

  private Map<Destination, Integer> destinationStatistics = new HashMap<>();

  public TripRecommender(Map<Destination, Integer> anonymizedData){
    this.destinationStatistics = anonymizedData;
  }

  public Map<Destination, Integer> getAggregatedStatistics() {
    return destinationStatistics;
  }

  private Map<Destination, Integer> getAggregatedStatistics(List<Traveler> traveler) {
    Map<Destination, Integer> resultingMap = new HashMap<>();
    int listSize = traveler.size();

    if (traveler == null || traveler.size() == 0) {
      return resultingMap;
    }

    for (Traveler tra : traveler) {
      for (Destination dest : tra.traveledDestinations()) {
        resultingMap.putIfAbsent(dest, 1);
        resultingMap.put(dest, resultingMap.get(dest) + 1);
      }
    }
    return resultingMap;
  }

  private Destination recommendMostLikelyDestination(){
    int mostLikely = this.getAggregatedStatistics().values().stream().max(Integer::compare).get();
    for (Destination des: this.getAggregatedStatistics().keySet()){
      if (this.getAggregatedStatistics().get(des) == mostLikely)
        return des;
    }
    return null;
  }

  private Destination recommendMostunLikelyDestination(){
    int mostunLikely = this.getAggregatedStatistics().values().stream().min(Integer::compare).get();
    for (Destination des: this.getAggregatedStatistics().keySet()){
      if (this.getAggregatedStatistics().get(des) == mostunLikely)
        return des;
    }
    return null;
  }


}

