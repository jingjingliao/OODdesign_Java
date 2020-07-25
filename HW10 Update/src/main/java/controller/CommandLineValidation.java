package controller;

/**
 * Validates command line arguments Class
 */
public class CommandLineValidation {
  private static final String RESERVE = "reserve";
  private static final String SHOW = "show";
  private static final String DONE = "done";
  private static final String HELP_MESSAGE = "Please enter \"show\", \"done\" or \"reserve (number from 1 to 10 inclusively)\"";
  private String answer;

  private static final int MIN_LENGTH = 1;
  private static final int MAX_LENGTH = 2;

  /**
   * Validate args
   * @param args String args
   */
  public CommandLineValidation(String args) {
    String[] answers = new String[]{};
    answers = args.split(" ");
    this.checkLength(answers);
    this.processArgs(answers);
  }

  /**
   * Check the length of args
   * @param answer a string of args
   */
  private void checkLength(String[] answer) {
    if (answer.length < MIN_LENGTH || answer.length > MAX_LENGTH) {
      System.out.println(HELP_MESSAGE);
      System.out.println();
    }
  }

  /**
   * Process args based on its length
   * @param answers a string of args
   */
  private void processArgs(String[] answers) {
    if (answers.length == MIN_LENGTH){
      if (answers[0].equals(SHOW))
        answer = SHOW;
      else if (answers[0].equals(DONE))
        answer = DONE;
      else {
        System.out.println(HELP_MESSAGE);
        System.out.println();
      }
    }
    else if (answers.length == MAX_LENGTH){
      if (!answers[0].equals(RESERVE)){
        System.out.println(HELP_MESSAGE);
        System.out.println();
      }
      isValidateNum(answers[1]);
    }
  }

  /**
   * Check the input reserve num is valid
   * @param reserveNum the number of seats that you want to reserve
   */
  private void isValidateNum(String reserveNum) {
    if (!reserveNum.matches("[0-9]*")){
      System.out.println("Please enter a number from 1 to 10 inclusively after \"reserve\"");
      System.out.println();
    }
    else if (Integer.parseInt(reserveNum) > 10){
      System.out.println("Sorry, we don't have many seats together for you ");
      System.out.println();
    }
    else
      answer = reserveNum;
  }

  /**
   * Get the answer
   * @return the answer
   */
  public String getAnswer() {
    return answer;
  }

}
