package finalPractice7.problem03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRE {

  public static Boolean checkMatch(String stringToCheck){
    Pattern pattern = Pattern.compile("^12345?|^pa[s$]{2}.*");
    Matcher matcher = pattern.matcher(stringToCheck);
    return matcher.lookingAt();
  }

}
