package finalPractice7.problem02;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {

  /**
   * Calculate the negation number of the given list numbers, no duplication number
   * @param llp 2d array
   * @return the negation number of the numbers in the given 2d array
   */
  public List<Integer> flatten(List<List<Integer>> llp){
    List<Integer> result = new ArrayList<>();

    for (List<Integer> lp: llp){
      for (Integer intNumber: lp){
        if ((intNumber % 5 == 0) && !result.contains(Math.negateExact(intNumber)))
          result.add(Math.negateExact(intNumber));
      }
    }
    return result;
  }

}
