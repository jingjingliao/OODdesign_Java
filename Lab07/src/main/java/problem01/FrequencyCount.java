package problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCount {
  public static Map<Integer, Double> frequencyCount(List<Integer> list){
    Map<Integer, Double> map = new HashMap<>();

    if (list == null){
      return map;
    }
   for (Integer n: list){
     map.put(n, map.getOrDefault(n, 0.0) + 1);
   }

   for (Map.Entry<Integer, Double> entry: map.entrySet()){
     entry.setValue(entry.getValue() / list.size());
   }
   return map;
  }

}
