package finalPractice6.problem03;

public class TigData {
  private String operation;
  private boolean messageFlag;
  private String message;
  private boolean verboseFlag;

  public TigData(String operation, boolean messageFlag, String message, boolean verboseFlag) {
    this.operation = operation;
    this.messageFlag = messageFlag;
    this.message = message;
    this.verboseFlag = verboseFlag;
  }

  public String getOperation() {
    return operation;
  }

  public boolean isMessageFlag() {
    return messageFlag;
  }

  public String getMessage() {
    return message;
  }

  public boolean isVerboseFlag() {
    return verboseFlag;
  }
}
