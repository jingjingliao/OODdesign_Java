package problem02;

import java.util.List;
import java.util.Objects;

public class Swimmer implements Comparable<Swimmer> {

  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;


  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
      List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes){
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }

  public List<Double> getBreaststroke50mTimes() {
    return breaststroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  @Override
  public int compareTo(Swimmer otherSwimmer) {
    double avg1 = calculateAvg(this.freestyle50mTimes);
    double avg2 = calculateAvg(otherSwimmer.freestyle50mTimes);
    return Double.compare(avg1, avg2);
  }

  private double calculateAvg(List<Double> freestyle50mTimes){
    double numOfTimes = this.freestyle50mTimes.size();
    double sum = 0;
    for (Double i : freestyle50mTimes)
      sum = sum + i;
    double avg = sum / numOfTimes;
    return avg;
  }
}
