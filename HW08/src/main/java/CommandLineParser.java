import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a CommandLineParser
 */
public class CommandLineParser {
  /**
   * Specified commands
   */
  protected static final String PREFIX = "--";
  protected static final String EMAIL = "email";
  protected static final String LETTER = "letter";
  protected static final String TEMPLATE = "-template";
  protected static final String OUTPUT_DIR = "output-dir";
  protected static final String CSV_FILE = "csv-file";

  /**
   * Paths is a map that stores the relevant intput/output path in the command line arguments
   */
  protected Map<String, String> paths;
  /**
   * Indicates if email is required
   */
  protected boolean emailRequired;
  /**
   * Indicates if letter is required
   */
  protected boolean letterRequired;
  /**
   * Command line arguments
   */
  private String[] args;

  /**
   * Constructs a new CommandLineParser where emailRequired and letterRequired are set to be false by default
   * @param args Command line arguments
   */
  public CommandLineParser(String[] args){
    this.args = args;
    this.paths = new HashMap<>();
    this.emailRequired = false;
    this.letterRequired = false;
  }

  /**
   * Calls processArgs() and checks if the command line arguments are valid;
   * @throws InvalidArgumentsException thrown when invalid argument is found
   */
  public void parse() throws InvalidArgumentsException{
    this.processArgs();
    if(emailRequired && !this.paths.containsKey(EMAIL+TEMPLATE)){
      throw new InvalidArgumentsException("Error: " + PREFIX+EMAIL  + " provided but no " + PREFIX+EMAIL+TEMPLATE + " was given.");
    }else if(!emailRequired && this.paths.containsKey(EMAIL+TEMPLATE)){
      throw new InvalidArgumentsException("Error: " + PREFIX+EMAIL+TEMPLATE + " provided but no " + PREFIX+EMAIL + " was given.");
    }
    if(letterRequired && !this.paths.containsKey(LETTER+TEMPLATE)){
      throw new InvalidArgumentsException("Error: " + PREFIX+LETTER  + " provided but no " + PREFIX+LETTER+TEMPLATE + " was given.");
    }else if(!letterRequired && this.paths.containsKey(LETTER+TEMPLATE)){
      throw new InvalidArgumentsException("Error: " + PREFIX+LETTER+TEMPLATE + " provided but no " + PREFIX+LETTER + " was given.");
    }
    if(!emailRequired && !letterRequired){
      throw new InvalidArgumentsException("Neither email or letter is indicated.");
    }
    if(!this.paths.containsKey(CSV_FILE)){
      throw new InvalidArgumentsException("Error: no " + CSV_FILE + " was given.");
    }
    if(!this.paths.containsKey(OUTPUT_DIR)){
      throw new InvalidArgumentsException("Error: no " + OUTPUT_DIR + " was given.");
    }
  }



  /**
   * Checks and processes the input/output path; when there are duplicated valid commands involving input/output paths,
   * the latest will overwrite the previous
   * @param argIdx the index of the path in arguments array
   * @param type a string that indicates what type of path we are processing
   * @throws InvalidArgumentsException thrown when an invalid argument is found
   */
  private void processPath(int argIdx, String type) throws InvalidArgumentsException {
    if (argIdx >= this.args.length || this.args[argIdx].startsWith(PREFIX)){
      throw new InvalidArgumentsException(("Missing output path: " +  type));
    }
    this.paths.put(type, this.args[argIdx]);
  }

  /**
   * Parses command line arguments and checks if the arguments are valid
   * @throws InvalidArgumentsException thrown when an invalid argument is found
   */
  private void processArgs() throws InvalidArgumentsException{
    if (this.args == null || this.args.length == 0){ throw new InvalidArgumentsException("No command given"); }
    for (int i = 0; i < this.args.length; i++) {
      switch(this.args[i]) {
        case PREFIX+EMAIL: this.emailRequired = true; break;
        case PREFIX+LETTER: this.letterRequired = true; break;
        case PREFIX+EMAIL+TEMPLATE:
          processPath(++i, EMAIL+TEMPLATE);
          break;
        case PREFIX+LETTER+TEMPLATE:
          processPath(++i, LETTER+TEMPLATE);
          break;
        case PREFIX+CSV_FILE:
          processPath(++i, CSV_FILE);
          break;
        case PREFIX+OUTPUT_DIR:
          processPath(++i, OUTPUT_DIR);
          break;
        default:
          throw new InvalidArgumentsException("Unknown command: " + this.args[i]);
      }
    }
  }

  /**
   * Overrides the equals() method for CommandLineParser
   * @param o the object being compared to this CommandLineParser
   * @return true if o equals CommandLineParser, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CommandLineParser that = (CommandLineParser) o;
    return emailRequired == that.emailRequired &&
            letterRequired == that.letterRequired &&
            paths.equals(that.paths) &&
            Arrays.equals(args, that.args);
  }

  /**
   * Overrides the hashCode() method for CommandLineParser
   * @return the hashcode of this CommandLineParser
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(paths, emailRequired, letterRequired);
    result = 31 * result + Arrays.hashCode(args);
    return result;
  }

  /**
   * Overrides the toString() method for CommandLineParser
   * @return the string representation of this CommandLineParser
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
            "paths=" + paths +
            ", emailRequired=" + emailRequired +
            ", letterRequired=" + letterRequired +
            ", args=" + Arrays.toString(args) +
            '}';
  }
}