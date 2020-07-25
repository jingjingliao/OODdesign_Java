import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a generator which generates text files
 */
public class Generator implements IGenerator{

  protected static String PLACEHOLDER_L = "\\[\\[";
  protected static String PLACEHOLDER_R = "]]";

  /**
   * Main method of Generator class. Generate output files by given template and csv data.
   * @param templateData The template text and tags, given as a TemplateDataReader object.
   * @param csvData The csv information and tags, given as a CSVDataReader object.
   * @param outputPath The outputPath, given as a String.
   * @throws Exception If error happens while generating txt files.
   */
  public void generate(TemplateDataReader templateData, CSVDataReader csvData, String outputPath) throws Exception{

    // Check data
    if (templateData == null || csvData == null || outputPath == null)
      throw new NullPointerException("No data given.");

    // Generate Tag Mapping
    Map<String, Integer> tagMapping = buildTagIndex(templateData.tags, csvData.tags);

    // Write Files
    writeFiles(templateData.template, csvData.info, tagMapping, outputPath);
  }

  /**
   * A helper method to build the pairs of tags (which appears in template) and index (which is
   * relevant to it's corresponding column index in the csv file)
   * @param templateTags all tags in the template, as a set of Strings
   * @param csvTags all tags in the csv file, as a list of Strings
   * @return the mapping of <tags, index> as <String, Integer>
   * @throws TagsMismatchException if tags cannot match.
   */
  protected Map<String, Integer> buildTagIndex(Set<String> templateTags,
                                            List<String> csvTags) throws TagsMismatchException{

    if (csvTags == null || templateTags == null){
      throw new NullPointerException("No Tags.");
    }
    else if(!csvTags.containsAll(templateTags)){
      throw new TagsMismatchException("Cannot accommodate CSV file to the template.");
    }
    else{
      Map<String, Integer> mapping = new HashMap<>();
      for(String tag: templateTags){
        mapping.put(tag, csvTags.indexOf(tag));
      }
      return mapping;
    }
  }

  /**
   * A helper method to write multiple files for all supporters.
   * @param template The template, given as a list of Strings.
   * @param csvDataInfo All info from csv file, given as a list of list of Strings.
   * @param tagMapping The pre-process mapping of tags, <tags, index> as <String, Integer>
   * @param outputDirectory The assigned output path, as a string
   * @throws Exception If any error happens while writing the files.
   */
  protected void writeFiles(List<String> template, List<List<String>> csvDataInfo,
                            Map<String, Integer> tagMapping, String outputDirectory) throws Exception{

    outputDirectory = outputDirectory.replaceAll("(^/)|(/$)", "");
    createFolder(outputDirectory);

    for (int idx = 0; idx < csvDataInfo.size(); idx++) {       // Loop through every supporter
      List<String> output = buildOutputText(template, csvDataInfo.get(idx), tagMapping);
      writeSingleFile(output,  outputDirectory + "/" + idx + ".txt");
    }
  }

  /**
   * A helper method to create folders for output files.
   * @param outputFileDirectory The given output directory as a String
   * @throws Exception If any error happens while creating the folder.
   */
  protected void createFolder(String outputFileDirectory) throws Exception{
    if (outputFileDirectory == null)
      throw new NullPointerException("No output file path given.");

    try {
      Paths.get(outputFileDirectory);
    } catch (InvalidPathException e) {
      throw new IllegalArgumentException(outputFileDirectory + " is an invalid path. " + e.getReason());
    }

    File ROOT_DIRECTORY = new File(System.getProperty("user.dir"));
    File newDirectory = new File(ROOT_DIRECTORY, outputFileDirectory);


    if (newDirectory.exists() && newDirectory.isFile()){
      throw new IllegalArgumentException("New Directory exists as a file.");
    }

    try{
      newDirectory.mkdirs();
    }
    catch (Exception e){
      throw new Exception("Something went wrong while creating the folder. ", e.getCause());
    }
  }

  /**
   * A helper method to generate output text.
   * @param template The input template, given as a list of Strings.
   * @param individualInfo An individual's info, given as a list of Strings.
   * @param tagMapping The pre-process mapping of tags, <tags, index> as <String, Integer>
   * @return the output text as a list of Strings
   */
  protected ArrayList<String> buildOutputText(List<String> template, List<String> individualInfo, Map<String, Integer> tagMapping) {
    ArrayList<String> outputText = new ArrayList<>(template);

    for (Map.Entry<String, Integer> pair : tagMapping.entrySet()) {  // loop through every tag
      String tag = pair.getKey();
      Integer tagId = pair.getValue();

      String regex = PLACEHOLDER_L + tag + PLACEHOLDER_R;
      Pattern pattern = Pattern.compile(regex);
      for (int i = 0; i < outputText.size(); i++) {                 // loop through every line
        Matcher matcher = pattern.matcher(outputText.get(i));
        String stringToBeReplaced = individualInfo.get(tagId);
        outputText.set(i, matcher.replaceAll(stringToBeReplaced));
      }
    }
    return outputText;
  }

  /**
   * A helper method to write single file for an individual.
   * @param outputText The output text to be written, given as a list of Strings.
   * @param outputFileName The output file name, given as a String.
   * @throws Exception If any error happens while creating the folder.
   */
  protected static void writeSingleFile(List<String> outputText, String outputFileName) throws Exception{
    try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(outputFileName))) {
      for (String line: outputText){
        outputFile.write(line + System.lineSeparator());
      }
    }
    catch (IOException ioe) {
      throw new IOException("Something went wrong while writing the file: " + outputFileName + ioe.getMessage());
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return 41;
  }

  @Override
  public String toString() {
    return "Generator{}";
  }

}

