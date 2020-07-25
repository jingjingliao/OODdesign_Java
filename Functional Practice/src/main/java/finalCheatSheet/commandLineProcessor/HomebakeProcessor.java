package finalCheatSheet.commandLineProcessor;

public class HomebakeProcessor {
  private String operation = null;
  private String formula = null;
  private boolean wFlag = false;
  private boolean vFlag = false;
  private boolean dFlag = false;
  private static final String USAGE = "Provide some usage here.";

  public HomebakeData parse(String[] args) {
    checkLength(args);
    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      if (arg.equals("-install") || arg.equals("-uninstall") || arg.equals("-update")) {
        parseOperation(args, i++, arg);
      } else if (arg.startsWith("-")) {
        parseFlag(arg);
      } else {
        throw new IllegalArgumentException("Argument format error.");
      }
    }
    checkRequired();
    return new HomebakeData(operation, formula, wFlag, vFlag, dFlag);
  }

  private void checkLength(String[] args) {
    if (args.length < 2 || args.length > 5) {
      throw new IllegalArgumentException("Wrong length of arguments.");
    }
  }

  private void parseOperation(String[] args, int i, String arg) {
    if (operation == null) {
      operation = arg;
      parseFormula(args, i);
    } else {
      throw new IllegalArgumentException("Duplicate operation is provided.");
    }
  }

  private void parseFormula(String[] args, int i) {
    if (i == args.length - 1 || args[i + 1].startsWith("-")) {
      throw new IllegalArgumentException(String.format("Operation %s is provided, but formula is missing", operation));
    }
    formula = args[i + 1];
  }

  private void parseFlag(String arg) {
    switch (arg) {
      case "-w":
        wFlag = true;
        break;
      case "-v":
        vFlag = true;
        break;
      case "-d":
        dFlag = true;
        break;
      default:
        throw new IllegalArgumentException(String.format("Unknown argument %s.", arg));
    }
  }

  private void checkRequired() {
    if (operation == null) {
      throw new IllegalArgumentException("Operation argument is missing.");
    }
  }

  public static void main(String[] args) {
    HomebakeProcessor processor = new HomebakeProcessor();
    try {
      HomebakeData data = processor.parse(args);
      // Print here to see if the data is what we expected.
      System.out.println(data);
      // Use the data to run corresponding operations here. No requirement in this assignment.
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
      System.out.println(USAGE);
    }
  }
}