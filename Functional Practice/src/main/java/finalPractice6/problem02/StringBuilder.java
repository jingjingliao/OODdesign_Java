package finalPractice6.problem02;

import finalPractice7.problem02.SaltedString;
import finalPractice7.problem02.StringSalter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringBuilder {

  private List<String> elemList = new ArrayList<>();
  private HashMap<String, StringInfo> saltedString = new HashMap<>();

  public static Map<String, StringInfo> comoputeStringInfo(List<String> startingList) {
    Map<String, StringInfo> resultingMap = new HashMap<>();
    int listSize = startingList.size();

    if (startingList.size() == 0) {
      return resultingMap;
    }
    for (String currentStr : startingList) {
      if (!resultingMap.containsKey(currentStr.toLowerCase())) {
        resultingMap.put(currentStr.toLowerCase(), new StringInfo(currentStr.length(), 1));
      } else {
        StringInfo info = resultingMap.get(currentStr.toLowerCase());
        info.setOccurences(info.getOccurences() + 1);
      }
    }
    return resultingMap;
  }

  public static void main(String[] args){
    List<String> stringList = new ArrayList<>(Arrays.asList("happy", "Easter", "bunny", "Earth", "DAY", "Bunny", "day"));
    System.out.println(StringBuilder.comoputeStringInfo(stringList));
  }
}
