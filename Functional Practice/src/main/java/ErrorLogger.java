import java.util.ArrayList;
import java.util.List;

public class ErrorLogger {
  private List<String> log;

  public ErrorLogger(){
    this.log = new ArrayList<>();
  }

  public void log(String event){
    this.log.add(event);
  }

  public boolean isEmpty(){
    return this.log.size() == 0;
  }
}
