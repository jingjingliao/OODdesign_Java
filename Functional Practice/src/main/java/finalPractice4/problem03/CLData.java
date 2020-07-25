package finalPractice4.problem03;


import com.sun.org.apache.bcel.internal.generic.POP;

public class CLData implements ICLData {
  private Integer port;
  private String hostname;
  private Boolean encrypted;

  public CLData(Integer port, String hostname, Boolean encrypted) {
    this.port = port;
    this.hostname = hostname;
    this.encrypted = encrypted;
  }

  @Override
  public CLData createCLData(Integer port, String hostname, Boolean encrypted) {
    return new CLData(port, hostname, encrypted);
  }

}
