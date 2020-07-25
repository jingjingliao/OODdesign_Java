import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a CSV data reader which reads the CSV file and extracts the tags and information
 */
public class CSVDataReader implements IDataReader {

  protected List<String> tags;   // ["first_name", "last_name", "company_name"]
  protected List<List<String>> info; // [["James","Butt","Benton, John B Jr"],
                                      // ["Simona","Morasca","Chapman, Ross E Esq"]]
  private static final String PATTERN = "\"([^\"]*)\"";

  /**
   * Constructs a CSVDataReader
   */
  public CSVDataReader() {
    this.tags = new ArrayList<>();
    this.info = new ArrayList<>();
  }

  /**
   * Helper function that extract content between quotes by regular expression
   * @param line the line that I need to read and extract
   * @return an arraylist which contains correct information that extract from the line by given
   * RE pattern
   * @throws InvalidContentException throw exception if the given line is null
   */
  private List<String> extractContentBetweenQuotes(String line) throws InvalidContentException {
    if (line == null)
      throw new InvalidContentException("No content!");
    List<String> content = new ArrayList<>();
    Pattern pattern = Pattern.compile(PATTERN);
    Matcher m = pattern.matcher(line);
    while (m.find()) {
      content.add(m.group(1));
    }
    return content;
  }

  /**
   * Helper function that checks whether contain duplicate elements in tags
   * @param tags an arraylist that represents the elements in the first line of CSV file
   * @return true if it contains duplicate, otherwise return false
   */
  private boolean containDuplicate(List<String> tags){
    Set setTags = new HashSet(tags);
    return tags.size() != setTags.size();
  }

  /**
   * Read the file and extract information in tags and info
   * @param csvLocation the file location that we want to read
   * @throws Exception throw exception if the line is null or contain duplicate info
   */
  @Override
  public void read(String csvLocation) throws Exception {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvLocation))) {
      String line;
      line = inputFile.readLine();
      this.tags = this.extractContentBetweenQuotes(line);
      if (this.containDuplicate(this.tags)){
        throw new InvalidContentException("There is no content or contains duplicate content.");
      }
      while ((line = inputFile.readLine()) != null) {
        List<String> newLine;
        newLine = this.extractContentBetweenQuotes(line);
        this.info.add(newLine);
      }
    } catch (FileNotFoundException fnfe) {
      throw new FileNotFoundException("OOPS! A file was not found");
    } catch (IOException ioe) {
      throw new IOException("Something went wrong!");
    }
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CSVDataReader that = (CSVDataReader) o;
    return tags == that.tags &&
        info == that.info;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.tags, this.info);
  }

  @Override
  public String toString() {
    return "CSVDataReader{" +
        "tags=" + tags +
        ", info=" + info +
        '}';
  }
}
