package finalPractice7.problem01;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MainStream3 {
  public static void main(String[] args) {
    List<Runner> runners = new ArrayList<>();

    List<Double> fiveKTimes = new ArrayList<>();
    fiveKTimes.add(35.00);
    fiveKTimes.add(40.00);
    fiveKTimes.add(38.45);
    fiveKTimes.add(36.00);
    fiveKTimes.add(33.45);

    List<Double> tenKTimes = new ArrayList<>();
    tenKTimes.add(67.50);
    tenKTimes.add(70.00);
    tenKTimes.add(80.50);

    Runner runnerA = new Runner("Jane Smith", fiveKTimes, tenKTimes);

    fiveKTimes = new ArrayList<>();
    fiveKTimes.add(33.00);
    fiveKTimes.add(41.00);
    fiveKTimes.add(42.45);

    tenKTimes = new ArrayList<>();
    tenKTimes.add(71.50);
    tenKTimes.add(75.00);
    tenKTimes.add(72.50);

    Runner runnerB = new Runner("Ruth Barr", fiveKTimes, tenKTimes);

    runners.add(runnerA);
    runners.add(runnerB);

//    long num = runners.stream()
//                        .filter(runner -> runner.getFiveKRaceTimes().size() >= 4)
//                        .filter(runner -> calculateAvg(runner.getFiveKRaceTimes()) < 38.00).count();
    long num = runners.stream().filter(runner -> runner.getFiveKRaceTimes().size() >= 4)
                    .filter(runner -> runner.getFiveKRaceTimes().stream().mapToDouble(r -> r).average().getAsDouble() > 38.00).collect(Collectors.toList()).size();

    System.out.println(num);
  }

  public static double calculateAvg(List<Double> raceTime){
//    double count = (double)raceTime.stream().count();
    double count = raceTime.size();
   double total = raceTime.stream().reduce(0.0, Double::sum);
   return total / count;
  }

}
