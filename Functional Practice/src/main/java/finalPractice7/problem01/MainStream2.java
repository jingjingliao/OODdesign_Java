package finalPractice7.problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream2 {
  public static void main(String[] args) {
    List<Runner> runners = new ArrayList<>();

    List<Double> fiveKTimes = new ArrayList<>(Arrays.asList(35.0, 40.00, 38.45, 36.00, 33.45));
    List<Double> tenKTimes = new ArrayList<>(Arrays.asList(67.5, 70.00, 80.50));
    Runner runnerA = new Runner("Jane Smith", fiveKTimes, tenKTimes);

    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(33.00);
    fiveKTimes.add(41.00);
    fiveKTimes.add(42.45);
    fiveKTimes.add(43.00);

    tenKTimes = new ArrayList<>();
    tenKTimes.add(71.50);
    tenKTimes.add(75.50);
    tenKTimes.add(72.50);

    Runner runnerB = new Runner("Ruth Barr", fiveKTimes, tenKTimes);

    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(35.00);
    fiveKTimes.add(42.00);
    fiveKTimes.add(44.45);

    tenKTimes = new ArrayList<>();
    tenKTimes.add(71.50);
    tenKTimes.add(75.00);
    tenKTimes.add(72.50);

    Runner runnerC = new Runner("Ann Mach", fiveKTimes, tenKTimes);

    runners.add(runnerA);
    runners.add(runnerB);
    runners.add(runnerC);

    Comparator<Runner> numRaces = new Comparator<Runner>() {
      @Override
      public int compare(Runner r1, Runner r2) {
        return r1.getNumRaces() - r2.getNumRaces();
      }
    };

    System.out.println("Swimmers:" + runners);

    runners.sort(numRaces);
    System.out.println("Swimmers again:" + runners);

    System.out.println("Swimmers third time:" + runners.stream()
        .filter(runner -> runner.getNumRaces() >= 7)
        .map(Runner::getName).collect(
        Collectors.toList()));
  }
}
