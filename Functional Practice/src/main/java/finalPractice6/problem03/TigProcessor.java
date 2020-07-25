package finalPractice6.problem03;

import finalCheatSheet.commandLineProcessor.HomebakeData;

public class TigProcessor {
  private String operation = null;
  private boolean messageFlag = false;
  private String message = null;
  private boolean verboseFlag = false;

  public TigData parse(String[] args) throws InvalidArgumentException {
    checkLength(args);
    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      if (arg.equals("--commit") || arg.equals("--add") || arg.equals("--push")) {
        parseOperation(arg);
      } else if (arg.equals("--m")) {
        parseMessage(args, i, arg);
      } else if (arg.equals("--v")) {
        verboseFlag = true;
      } else {
        throw new IllegalArgumentException("Argument format error.");
      }
    }
    checkRequired();
    return new TigData(operation, messageFlag, message, verboseFlag);
  }

  private void checkLength(String[] args) throws InvalidArgumentException {
    if (args.length < 3 || args.length > 4)
      throw new InvalidArgumentException("Wrong length of arguments");
  }

  private void parseOperation(String arg) {
    if (operation == null)
      operation = arg;
    else
      throw new IllegalArgumentException("Duplicate operation is provided.");
  }

  private void parseMessage(String[] args, int i, String arg) throws InvalidArgumentException {
    if (!messageFlag) {
      messageFlag = true;
      processMessage(args, i + 1);
    } else {
      throw new IllegalArgumentException("Duplicate operation is provided.");
    }
  }

  private void processMessage(String[] args, int i) throws InvalidArgumentException {
    if (i >= args.length)
      throw new InvalidArgumentException("Message information is required");
    else
      this.message = args[i];
  }

  private void checkRequired() throws InvalidArgumentException {
    if (this.operation == null || this.messageFlag == false || this.message == null)
      throw new InvalidArgumentException("operation and message information is required");
  }
}
