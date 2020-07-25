package finalPractice7.problem02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSalter {

  private List<String> elemList = new ArrayList<>();
  private HashMap<String, SaltedString> saltedString = new HashMap<>();

  public static Map<String, SaltedString> computeSaltedString(List<String> startingList){
    Map<String, SaltedString> resultingMap = new HashMap<>();
    int listSize = startingList.size();

    if (startingList.size() == 0){
      return resultingMap;
    }
    for (String currentStr: startingList){
      if (!resultingMap.containsKey(currentStr))
        resultingMap.put(currentStr, new SaltedString(currentStr));
    }
    return resultingMap;
  }

  public static void main(String[] args){
    List<String> stringList = new ArrayList<>(Arrays.asList("happy", "Easter", "bunny", "Earth", "Bunny"));
    System.out.println(StringSalter.computeSaltedString(stringList));
  }


}
