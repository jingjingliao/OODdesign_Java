import controller.Controller;
import model.InvalidAmountException;
import model.Record;

public class Main {

  public static void main(String[] args) throws InvalidAmountException {
    Controller controller = new Controller();
    controller.controller();
  }
}
