package controller;

import java.util.List;
import java.util.Scanner;
import model.InvalidAmountException;
import model.Record;
import model.Type;
import view.View;

public class Controller {
  private static Scanner scanner = new Scanner(System.in);
  public static final String ONE = "1";
  public static final String TWO = "2";
  public static final String THREE = "3";
  public static final String FOUR = "4";

  public void controller() throws InvalidAmountException {
    Record records = Record.createRecord();
    View.printScreen();
    String answer = scanner.nextLine();
    while (!answer.equals(FOUR)){
      switch (answer){
        case ONE:
          View.accountDetails();
          View.updateRecord(records.getRecord());
          System.out.println();
          break;

        case TWO:
          changeAmount(Type.Income, records);
          break;

        case THREE:
          changeAmount(Type.Outcome, records);
          break;

        default:
          View.wrongMessage();
          break;
      }

      View.printScreen();
      answer = scanner.nextLine();
    }
  }

  private void changeAmount(Type type, Record records) throws InvalidAmountException {
    switch (type){
      case Income:
        View.getIncomeAmount();
        String income = scanner.nextLine();
        String message = getMessage();
        records.updateRecord(type.Income, income, message);
        break;
      case Outcome:
        View.getOutcomeAmount();
        String outcome = scanner.nextLine();
        String outmessage = getMessage();
        records.updateRecord(type.Outcome, outcome, outmessage);
        break;
    }
  }

  private String getMessage(){
    View.getMessage();
    String message = scanner.nextLine();
    return message;
  }

}
