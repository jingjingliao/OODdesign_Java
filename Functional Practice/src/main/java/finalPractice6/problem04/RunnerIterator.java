package finalPractice6.problem04;

import finalPractice7.problem04.Swimmer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class RunnerIterator implements Iterator<Runner> {
  private List<Runner> runners;
  private int current;
  private static final int FIVE_5K_RACES = 5;
  private static final double QUALIFY_MARATHON_TIME = 100.00;

  public RunnerIterator(List<Runner> runners){
    this.runners = this.filterRunners(runners);
    this.current = 0;
  }

  public List<Runner> filterRunners(List<Runner> runners){
    return runners.stream().filter(runner -> runner.getFiveKRaceTimes().size() >= FIVE_5K_RACES).filter(runner -> this.qualifyMarathon(runner.getHalfMarathonTimes())).collect(
        Collectors.toList());
  }

  private Boolean qualifyMarathon (List<Double> halfMarathon){
    for (Double num: halfMarathon){
      if (num >= QUALIFY_MARATHON_TIME)
        return true;
    }
    return false;
  }

  @Override
  public boolean hasNext() {
    return this.current < this.runners.size();
  }

  @Override
  public Runner next() {
    if (!hasNext())
      throw new NoSuchElementException();
    return runners.get(current++);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RunnerIterator that = (RunnerIterator) o;
    return Objects.equals(runners, that.runners) &&
        current == that.current;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.runners, this.current);
  }

  @Override
  public String toString() {
    return "SwimmerIterator{" +
        "runners=" + runners +
        ", current=" + current +
        '}';
  }

  public static void main(String[] args) throws Exception {
    List<Double> freestyle50mTimes1 = new ArrayList<>(Arrays.asList(10.0, 200.0, 3.0, 4.0, 5.0));
    List<Double> half1 = new ArrayList<>(Arrays.asList(150.0, 2.0, 3.0, 4.0, 5.0));
    Runner swimmer1 = new Runner("aaa", freestyle50mTimes1, null, half1);
    List<Double> freestyle50mTimes2 = new ArrayList<>(Arrays.asList(10.0, 200.0, 3.0, 4.0, 5.0));
    List<Double> half2 = new ArrayList<>(Arrays.asList(1.0, 200.0, 3.0, 4.0, 5.0));
    Runner swimmer2 = new Runner("bbb", freestyle50mTimes2, null, half2);
    List<Runner> runners = new ArrayList<>(Arrays.asList(swimmer1, swimmer2));
    Iterator<Runner> itr = new RunnerIterator(runners);
    List<Runner> filterRunners = new ArrayList<>();
    while (itr.hasNext()) {
      Runner swimmer = itr.next();
      filterRunners.add(swimmer);
    }
    System.out.println(filterRunners.get(1).getName());
  }
}
