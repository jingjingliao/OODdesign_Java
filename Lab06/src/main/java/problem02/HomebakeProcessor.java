package problem02;

public class HomebakeProcessor {

  public String operation = null;
  public final String INSTALL = "--install";
  public final String UNINSTALL = "--uninstall";
  public final String UPDATE = "--update";
  public String formula = null;

  public static final String WARNING_FLAG = "--q";
  public static final String VERBOSE_FLAG = "--v";
  public static final String DEBUG_FLAG = "--d";

  public Boolean warningFlag = false;
  public Boolean verboseFlag = false;
  public Boolean debug_flag = false;

  public HomebakeProcessor (String[] args) throws InvalidArgumentsException {
    if (!this.checkLength(args))
      throw new InvalidArgumentsException("Length is invalid!");
    this.processArgs(args);
  }

  private boolean checkLength(String[] args){
    return 2 <= args.length && args.length <= 5;
  }

  private void processArgs(String[] args) throws InvalidArgumentsException {
    for (int i = 0; i < args.length; i++){
      String arg = args[i];
      if (arg.equals(INSTALL) || arg.equals(UNINSTALL) || arg.equals(UPDATE)){
        this.parseOperation(args, i++, arg);
      } else if (arg.startsWith("-")){
        this.parseFlag(arg);
      } else {
        throw new IllegalArgumentException("Argument format error.");
      }
    }
    checkRequired();
  }

  private void parseOperation(String[] args, int i, String arg) {
    if (this.operation == null) {
      this.operation = arg;
      parseFormula(args, i);
    } else {
      throw new IllegalArgumentException("Duplicate operation is provided");
    }
  }

  private void parseFormula(String[] args, int i){
    if (i == args.length - 1 || args[i+1].startsWith("-")){
      throw new IllegalArgumentException(String.format("Operation %s is provided, but formula is missing", operation));
    }
    this.formula = args[i+1];
  }

  private void parseFlag(String arg){
    switch (arg){
      case WARNING_FLAG:
        this.warningFlag = true;
        break;
      case VERBOSE_FLAG:
        this.verboseFlag = true;
        break;
      case DEBUG_FLAG:
        this.debug_flag = true;
        break;
      default:
        throw new IllegalArgumentException(String.format("Unknown argument %s.", arg));
    }
  }

  private void checkRequired(){
    if (operation == null){
      throw new IllegalArgumentException("Operation argument is missing");
    }
  }

}
