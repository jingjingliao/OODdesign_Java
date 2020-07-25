package problem01;

import static problem01.FrequencyCount.frequencyCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args){
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1,1,1,2,2,3,3,4,4,4));
    System.out.println(frequencyCount(list1));
  }

}
