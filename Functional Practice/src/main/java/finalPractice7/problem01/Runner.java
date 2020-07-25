package finalPractice7.problem01;

import java.util.List;

public class Runner {
  private String name;
  private List<Double> fiveKRaceTimes;
  private List<Double> tenKRaceTimes;

  public Runner(String name, List<Double> fiveKRaceTimes,
      List<Double> tenKRaceTimes) {
    this.name = name;
    this.fiveKRaceTimes = fiveKRaceTimes;
    this.tenKRaceTimes = tenKRaceTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getFiveKRaceTimes() {
    return fiveKRaceTimes;
  }

  public List<Double> getTenKRaceTimes() {
    return tenKRaceTimes;
  }

  public Integer getNumRaces(){
    return this.fiveKRaceTimes.size() + this.getTenKRaceTimes().size();
  }

  @Override
  public String toString() {
    return "Runner{" +
        "name='" + name + '\'' +
        '}';
  }

}
