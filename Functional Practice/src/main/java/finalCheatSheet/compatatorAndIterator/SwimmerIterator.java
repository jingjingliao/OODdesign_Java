package finalCheatSheet.compatatorAndIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class SwimmerIterator implements Iterator<Swimmer> {
  private List<Swimmer> runners;
  private int current;
  private static final int FIVE_BUTTERFLY_SWIM_TIME = 5;
  private static final double QUALIFY_OLYMPIC_TIME = 26.17;

  public SwimmerIterator(List<Swimmer> runners){
    this.runners = this.filterRunners(runners);
    this.current = 0;
  }

  public List<Swimmer> filterRunners(List<Swimmer> runners){
    return runners.stream().filter(runner -> runner.getButterfly50mTimes().size() >= FIVE_BUTTERFLY_SWIM_TIME).filter(runner -> this.filterSwims(runner.getFreestyle50mTimes())).collect(
        Collectors.toList());
  }

  private Boolean filterSwims (List<Double> freeStyleSwim){
    if (freeStyleSwim == null || freeStyleSwim.size() == 0)
      return false;
    for (Double num: freeStyleSwim){
      if (num >= QUALIFY_OLYMPIC_TIME)
        return true;
    }
    return false;
  }

  @Override
  public boolean hasNext() {
    return this.current < this.runners.size();
  }

  @Override
  public Swimmer next() {
    if (!hasNext())
      throw new NoSuchElementException();
    return runners.get(current++);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SwimmerIterator that = (SwimmerIterator) o;
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
    List<Double> butterfly50mTimes1 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
    Swimmer swimmer1 = new Swimmer("aaa", butterfly50mTimes1, null, null, freestyle50mTimes1);
    List<Double> freestyle50mTimes2 = new ArrayList<>(Arrays.asList(10.0, 200.0, 3.0, 4.0, 5.0));
    List<Double> butterfly50mTimes2 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
    Swimmer swimmer2 = new Swimmer("bbb", butterfly50mTimes2, null, null, freestyle50mTimes2);
    List<Swimmer> runners = new ArrayList<>(Arrays.asList(swimmer1, swimmer2));
    Iterator<Swimmer> itr = new SwimmerIterator(runners);
    List<Swimmer> filterRunners = new ArrayList<>();
    while (itr.hasNext()) {
      Swimmer swimmer = itr.next();
      filterRunners.add(swimmer);
    }
    System.out.println(filterRunners);
  }
}
