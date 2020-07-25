package p3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringProcessor2 {
  private List<String> someString = new ArrayList<>();

  public StringProcessor2(List<String> someString){
    this.someString = someString;
  }

  public Map<String, Integer> countChosenLetters(char letterA, char letterB){
    Map<String, Integer> res = new HashMap<>();
    for (String strr: getSomeString()){
      countLetters(res, strr, letterA, letterB);
    }
    return res;
  }

  private void countLetters(Map<String, Integer> res, String strr, char letterA, char letterB){
    String lowercase = strr.toLowerCase();
    for (int k = 0; k < lowercase.length(); k++){
      if (lowercase.charAt(k) == letterA || lowercase.charAt(k) == letterB){
        res.putIfAbsent(strr, 1);
        res.put(strr, res.get(strr) + 1);
      }
    }
  }

  public List<String> getSomeString() {
    return someString;
  }

}
