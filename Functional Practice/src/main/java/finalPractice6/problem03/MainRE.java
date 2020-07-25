package finalPractice6.problem03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRE {

  public static void main(String[] args) {
//    Pattern re1 = Pattern.compile("(\\d{3} )*\\d{3}-\\d{4}");
//    Matcher matcher1 = re1.matcher("(206) 505-6756");
//    System.out.println(" First String matched? " + matcher1.matches());
//    Matcher matcher2 = re1.matcher("206 206 505-6767");
//    System.out.println(" Second String matched? " + matcher2.matches());
//    Matcher matcher3 = re1.matcher("206 505-6756");
//    System.out.println(" Third String matched? " + matcher3.matches());
//    Matcher matcher4 = re1.matcher("505-6756");
//    System.out.println(" Fourth String matched? " + matcher4.matches());
//    Matcher matcher5 = re1.matcher("505-6756 505-6756");
//    System.out.println(" Fifth String matched? " + matcher5.matches());

    System.out.println(checkMatch("waupassspa$$sswie"));
  }

  public static Boolean checkMatch(String stringToCheck){
    Pattern pattern = Pattern.compile("password|pass|pswd|pa\\$\\$");
    Matcher matcher = pattern.matcher(stringToCheck);
    return matcher.find();
  }
}
