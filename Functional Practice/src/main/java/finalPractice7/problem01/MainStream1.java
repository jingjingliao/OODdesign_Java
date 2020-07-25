package finalPractice7.problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainStream1 {

  public static void main(String[] args) {
//    List<Double> listDoubles = new ArrayList<>(
//        Arrays.asList(171.98, 223.45, 345.79, 545.77, 121.33));

//    listDoubles.stream()
//        .map((Double element) -> Math.ceil(element))
//        .filter((Double value) -> value < 225.00)
//        .forEach(System.out::println);
//  }

//    listDoubles.stream()
//        .map(elment -> Math.ceil(elment))
//        .filter(value -> value < 225.00)
//        .forEach(System.out::println);

    List<String> phoneNums = new ArrayList<>();
    phoneNums.add("(206) 123-5678");
    phoneNums.add("(425) 345-5678");
    phoneNums.add("(505) 5676678");
    phoneNums.add("(206) 3455678");

    List<String> areaCodes = phoneNums.stream()
        .map(MainStream1::getAreaCodes)
        .collect(Collectors.toList());

    areaCodes.stream().forEach(System.out::println);
  }

  public static String getAreaCodes (String s){
    StringBuilder resultingString = new StringBuilder();

    Pattern pattern = Pattern.compile("(\\d{3})");
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()){
      resultingString.append(matcher.group(0));
      return resultingString.toString();
    }
    return null;
  }

}
