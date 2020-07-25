package view;

import java.util.List;

public class View {
  public static void printScreen(){
    System.out.println("----------家庭收支记账软件----------");
    System.out.println();
    System.out.println("           1 收支明细"             );
    System.out.println("           2 登记收入"             );
    System.out.println("           3 登记支出"             );
    System.out.println("           4 退   出"             );
    System.out.println();
    System.out.println("请选择<1-4>:");
  }

  public static void accountDetails(){
    System.out.println("----------当前收支明细记录----------");
    System.out.println("收支    账户金额    收支金额    说 明");
  }

  public static void updateRecord(List<List<String>> record){
    for (List<String> list: record){
      for (String info: list){
        System.out.print(info + "\t\t\t\t");
      }
      System.out.println();
    }
  }


  public static void wrongMessage(){
    System.out.println("输入有误，请重新输入");
  }

  public static void getIncomeAmount(){
    System.out.println("本次收入金额：");
  }

  public static void getOutcomeAmount(){
    System.out.println("本次支出金额：");
  }

  public static void getMessage(){
    System.out.println("本次收入说明：");
  }


}
