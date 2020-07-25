package problem02;

public class Main {
  public static void main(String[] args) {
    try {
      HomebakeProcessor parser = new HomebakeProcessor(args);
      HomebakeData data = new HomebakeData(parser.operation, parser.formula, parser.warningFlag, parser.verboseFlag, parser.debug_flag);
      System.out.println(data.getformula());
      System.out.println(data.getOperation());
      System.out.println(data.getverboseFlag());

    } catch (InvalidArgumentsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }
}
