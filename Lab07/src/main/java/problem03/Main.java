package problem03;

import java.util.ArrayList;
import java.util.List;
import problem02.Swimmer;

public class Main {
  public static void main(String[] args) {
   List<Swimmer> runners = new ArrayList<Swimmer>();
   List<Double> butter = new ArrayList<>();
   butter.add(20.0);
    List<Double> back = new ArrayList<>();
    back.add(30.0);
    List<Double> breast = new ArrayList<>();
    breast.add(40.0);
    List<Double> free = new ArrayList<>();
    free.add(50.0);
    free.add(40.0);
    List<Double> butter1 = new ArrayList<>();
    butter1.add(30.0);
    butter1.add(40.0);
   Swimmer swimmer1 = new Swimmer("Red", butter, back, breast, free);
    Swimmer swimmer2 = new Swimmer("Yellow", butter1, back, breast, free);
    runners.add(swimmer1);
    runners.add(swimmer2);

    for (Swimmer swimmer: runners){
      System.out.println(swimmer);
    }
  }


}
