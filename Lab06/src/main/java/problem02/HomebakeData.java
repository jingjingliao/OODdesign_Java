package problem02;

public class HomebakeData {
  private String operation;
  private String formula;
  private Boolean warningFlag;
  private Boolean verboseFlag;
  private Boolean debugFlag;

  public HomebakeData(String operation, String formula, Boolean warningFlag, Boolean verboseFlag, Boolean debugFlag) {
    this.operation = operation;
    this.formula = formula;
    this.warningFlag = warningFlag;
    this.verboseFlag = verboseFlag;
    this.debugFlag = debugFlag;
  }

  public String getOperation(){
    return this.operation;
  }

  public String getformula(){
    return this.formula;
  }

  public Boolean getwarningFlag(){
    return this.warningFlag;
  }

  public Boolean getverboseFlag(){
    return this.verboseFlag;
  }

}
