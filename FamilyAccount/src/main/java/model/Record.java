package model;

import java.util.ArrayList;
import java.util.List;

public class Record {

  private List<List<String>> record;
  private int totalAmount;
  private static Record instance;

  private Record(){
    this.record = new ArrayList<>();
    this.totalAmount = 0;
  }

  public static Record createRecord() {
    if (instance == null) {
      return new Record();
    }
    return instance;
  }

  public void updateRecord(Type type, String income, String message)
      throws InvalidAmountException {
    boolean flag = true;
    checkAmount(flag, income);
    if (flag){
      List<String> info = new ArrayList<>();
      switch (type){
        case Income:
          this.totalAmount += Integer.parseInt(income);
          info.add("收入");
          break;
        case Outcome:
          this.totalAmount -= Integer.parseInt(income);
          info.add("支出");
          break;
      }
      info.add(Integer.toString(totalAmount));
      info.add(income);
      info.add(message);
      this.record.add(info);
    }
  }

  private void checkAmount(boolean flag, String amount) throws InvalidAmountException {
    if (!amount.matches("[0-9]+")) {
      flag = false;
      System.out.println("Invalid input");
    }
  }

  public List<List<String>> getRecord() {
    return record;
  }

  public int getTotalAmount() {
    return totalAmount;
  }
}
