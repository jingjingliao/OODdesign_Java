package finalPractice7.problem03;

public class HomebakeData {
  private String operation;
  private String formula;
  private Boolean warningsFlag;
  private Boolean verboseFlag;
  private Boolean debugFlag;

  public HomebakeData(String operation, String formula, Boolean warningsFlag, Boolean verboseFlag, Boolean debugFlag){
    this.operation = operation;
    this.formula = formula;
    this.warningsFlag = warningsFlag;
    this.verboseFlag = verboseFlag;
    this.debugFlag = debugFlag;
  }

  public String getOperation() {
    return operation;
  }

  public String getFormula() {
    return formula;
  }

  public Boolean getWarningsFlag() {
    return warningsFlag;
  }

  public Boolean getVerboseFlag() {
    return verboseFlag;
  }

  public Boolean getDebugFlag() {
    return debugFlag;
  }
}
