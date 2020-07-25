package finalPractice4.problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainStreams2 {
  public static void main (String[] args){
    List<Integer> examPointsTotal = new ArrayList<>(Arrays.asList(20, 18, 17, 23));
    System.out.println(examPointsTotal.stream().reduce(0, new BinaryOperator<Integer>() {
      @Override
      public Integer apply(Integer integer, Integer integer2) {
        return integer + integer2;
      }
    }));
  }

}
