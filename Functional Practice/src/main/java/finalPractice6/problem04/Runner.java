package finalPractice6.problem04;

import finalPractice7.problem04.Swimmer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner implements Comparable<Runner>{
  private String name;
  private List<Double> fiveKRaceTimes;
  private List<Double> tenKRaceTimes;
  private List<Double> halfMarathonTimes;

  public Runner(String name, List<Double> fiveKRaceTimes, List<Double> tenKRaceTimes,
      List<Double> halfMarathonTimes) {
    this.name = name;
    this.fiveKRaceTimes = fiveKRaceTimes;
    this.tenKRaceTimes = tenKRaceTimes;
    this.halfMarathonTimes = halfMarathonTimes;
  }

  public String getName() { return name;
  }

  public List<Double> getFiveKRaceTimes() { return fiveKRaceTimes;
  }

  public List<Double> getTenKRaceTimes() { return tenKRaceTimes;
  }

  public List<Double> getHalfMarathonTimes() { return halfMarathonTimes;
  }

  @Override
  //YOUR CODE HERE
  public int compareTo(Runner otherRunner) {
    return Double.compare(this.get5KAvgTime(), otherRunner.get5KAvgTime());
  }

  private double get5KAvgTime(){
    return this.fiveKRaceTimes.stream().mapToDouble(t -> t).average().getAsDouble();
  }

  public static void main(String[] args) throws Exception {
    List<Double> fiveKRaceTimes1 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 10.0));
    Runner Runner1 = new Runner("aaa", fiveKRaceTimes1, null, null);
    List<Double> fiveKRaceTimes2 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
    Runner Runner2 = new Runner("bbb", fiveKRaceTimes2, null, null);
    int res = Runner1.compareTo(Runner2);
    System.out.println(res);
  }
}
