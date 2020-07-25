package problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {

  public static Map<String, Integer> countTopics1(List<String> topics) {
    Map<String, Long> occurence = new HashMap<>();
    occurence = topics.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<String, Integer> res = new HashMap<>();
    for (String s: occurence.keySet()){
      res.put(s, (int)((long) occurence.get(s)));
    }
    return res;
  }

  public static Map<String, Integer> countTopics2(List<String> topics) {
    return topics.stream().collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
  }

  public static Map<String, Integer> countTopics3(List<String> topics) {
    return topics.stream().collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
  }


  public static void main(String[] args) throws Exception{
    List<String> topics = new ArrayList<>(Arrays.asList("Seattle", "wildfires", "DEEF", "NEU", "NEU", "wildfires"));
    System.out.println(TrendingTopics.countTopics1(topics));

  }

}
