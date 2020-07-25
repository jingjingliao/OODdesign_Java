package finalPractice7.problem04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Swimmer implements Comparable<Swimmer> {
  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;
  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes, List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes; this.backstroke50mTimes = backstroke50mTimes; this.breaststroke50mTimes = breaststroke50mTimes; this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() { return name;
  }

  public List<Double> getButterfly50mTimes() { return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() { return backstroke50mTimes;
  }

  public List<Double> getBreaststroke50mTimes() { return breaststroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() { return freestyle50mTimes;
  }

  @Override
  //YOUR CODE HERE
  public int compareTo(Swimmer otherSwimmer) {
    double swimmer1 = this.getAvgFreestyleTime().orElse(-1);
    double swimmer2 = otherSwimmer.getAvgFreestyleTime().orElse(-1);
    return Double.compare(swimmer1, swimmer2);
  }

  private OptionalDouble getAvgFreestyleTime(){
    return this.freestyle50mTimes.stream().mapToDouble(t -> t).average();
  }

  public static void main(String[] args) throws Exception {
    List<Double> freestyle50mTimes1 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0));
    Swimmer swimmer1 = new Swimmer("aaa", null, null, null, freestyle50mTimes1);
    List<Double> freestyle50mTimes2 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
    Swimmer swimmer2 = new Swimmer("aaa", null, null, null, freestyle50mTimes2);
    int res = swimmer1.compareTo(swimmer2);
    System.out.println(res);
  }
}
