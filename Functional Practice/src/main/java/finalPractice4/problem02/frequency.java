package finalPractice4.problem02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class frequency {

  public static Map<Integer, Double> getFrequency(List<Integer> nums) {
    Map<Integer, Double> map = new HashMap<>();
    if (nums == null || nums.size() == 0)
      return map;
    for (Integer n: nums)
      map.put(n, map.getOrDefault(n, 0.0) + 1);

    for (Map.Entry<Integer, Double> entry: map.entrySet())
      entry.setValue(entry.getValue() / nums.size());

    return map;
  }

  public static void main(String[] args){
  List<Integer> list = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 4, 4));
    System.out.println(frequency.getFrequency(list));
  }

  
}

