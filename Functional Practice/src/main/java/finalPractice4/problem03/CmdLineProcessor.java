package finalPractice4.problem03;

import com.sun.org.apache.bcel.internal.generic.PUSH;

public class CmdLineProcessor {
  public CLData myCLData;
  private Integer port = null;
  private String hostname = "localhost";
  private Boolean encrypted = false;

  public CLData parse(String[] args) throws InvalidCommandException {
    checkLenth(args);
    for (int i = 0; i < args.length; i++){
      String arg = args[i];
      if (arg.matches("[0-9]*"))
        parsePort(arg);
      else if (arg.equals("--encrypt"))
        this.encrypted = true;
      else
        this.hostname = arg;
    }
    checkRequired();
    return myCLData.createCLData(port, hostname, encrypted);

  }

  private void checkLenth(String[] args) throws InvalidCommandException {
    if (args.length < 1 || args.length > 3)
      throw new InvalidCommandException("Invalid Length");
  }

  private void parsePort(String arg) throws InvalidCommandException {
    int portInt = Integer.parseInt(arg);
    if (portInt < 1000 || portInt > 65000)
      throw new InvalidCommandException("Port is invalid");
    else
      port = portInt;
  }

  private void checkRequired() throws InvalidCommandException {
    if (this.port == null)
      throw new InvalidCommandException("Port is required");
  }

}
