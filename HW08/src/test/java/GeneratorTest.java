import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class GeneratorTest {
  Generator g;
  TemplateDataReader templateData;
  CSVDataReader csvData;
  Map<String, Integer> mapping;
  String path;

  @Before
  public void setUp() throws Exception {

    templateData = new TemplateDataReader();
    templateData.tags = new HashSet<>(Arrays.asList("first_name", "last_name"));
    templateData.template = new ArrayList<>(Arrays.asList("Dear [[first_name]],", "[[first_name]] [[last_name]], thank you"));

    csvData = new CSVDataReader();
    csvData.tags = new ArrayList<>(Arrays.asList("first_name", "last_name", "phone_number"));
    csvData.info = new ArrayList<List<String>>(){};
    csvData.info.add(Arrays.asList("John", "Smith", "123.456.7890"));
    csvData.info.add(Arrays.asList("Monica", "Hilton", "222.234.5432"));

    mapping = new HashMap<String, Integer>(){{put("first_name", 0); put("last_name", 1);}};
    path = "output-dir/email";

    g = new Generator();

  }

  // Testing buildTagIndex--------------------------------------------------------------------------
  @Test
  public void buildTagIndex() throws TagsMismatchException{
    mapping = g.buildTagIndex(templateData.tags, csvData.tags);
    Map<String, Integer> expected = new HashMap<String, Integer>(){{put("first_name", 0); put("last_name", 1);}};
    assertTrue(expected.equals(mapping));
  }
  @Test (expected = NullPointerException.class)
  public void buildTagIndexFailedNull1() throws TagsMismatchException{
    mapping = g.buildTagIndex(null,null);
  }

  @Test (expected = NullPointerException.class)
  public void buildTagIndexFailedNull2() throws TagsMismatchException{
    mapping = g.buildTagIndex(templateData.tags,null);
  }

  @Test (expected = NullPointerException.class)
  public void buildTagIndexFailedNull3() throws TagsMismatchException{
    mapping = g.buildTagIndex(null,csvData.tags);
  }

  @Test (expected = TagsMismatchException.class)
  public void buildTagIndexFailedMismatch1() throws TagsMismatchException{
    mapping = g.buildTagIndex(new HashSet<>(Arrays.asList("address")), csvData.tags);
  }

  @Test (expected = TagsMismatchException.class)
  public void buildTagIndexFailedMismatch2() throws TagsMismatchException{
    mapping = g.buildTagIndex(templateData.tags, new ArrayList<>());
  }

  // Testing buildTagIndex--------------------------------------------------------------------------
  @Test
  public void createFolder() throws Exception {
    g.createFolder("output-dir/letter-folder");
  }

  @Test
  public void createFolder2() throws Exception {
    g.createFolder("");
  }

  @Test (expected = NullPointerException.class)
  public void createFolderFailed() throws Exception {
    g.createFolder(null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void createFolderFailed2() throws Exception {
    g.createFolder("letter-template.txt");
  }

  // Testing buildTagIndex--------------------------------------------------------------------------
  @Test
  public void buildOutputText(){
    List<String> expected = new ArrayList<>(Arrays.asList("Dear John,", "John Smith, thank you"));
    List<String> outputText = g.buildOutputText(templateData.template, Arrays.asList("John", "Smith", "123.456.7890"), mapping);
    assertEquals(expected, outputText);
  }

  @Test
  public void buildOutputText2(){
    List<String> expected = new ArrayList<>(Arrays.asList("No placeholder."));
    List<String> outputText = g.buildOutputText(
        new ArrayList<>(Arrays.asList("No placeholder.")),
        Arrays.asList("John", "Smith", "123.456.7890"),
        mapping);
    assertEquals(expected, outputText);
  }

  // Testing writeFile--------------------------------------------------------------------------
  @Test
  public void writeFile() throws Exception {
    g.writeFiles(templateData.template, csvData.info, mapping, "output-dir");
    g.writeFiles(templateData.template, csvData.info, mapping, "/output-dir");
    g.writeFiles(templateData.template, csvData.info, mapping, "output-dir/");
    g.writeFiles(templateData.template, csvData.info, mapping, "/output-dir/");
  }

  // Testing generate--------------------------------------------------------------------------
  @Test
  public void generate() throws Exception {
    g.generate(templateData, csvData, path);
  }

  @Test (expected = NullPointerException.class)
  public void generateFailed1() throws Exception {
    g.generate(null, csvData, path);
  }


  @Test (expected = NullPointerException.class)
  public void generateFailed2() throws Exception {
    g.generate(templateData, null, path);
  }


  @Test (expected = NullPointerException.class)
  public void generateFailed3() throws Exception {
    g.generate(templateData, csvData, null);
  }

  // Testing equals and hashcode
  @Test
  public void testEqual() throws Exception {
    assertTrue(g.equals(g));
    assertFalse(g.equals(null));
    assertFalse(g.equals("g"));
    assertTrue(g.equals(new Generator()));
    assertEquals(g.hashCode(), g.hashCode());
    assertEquals(new Generator().hashCode(), g.hashCode());
  }

  // Testing toString
  @Test
  public void testToString() throws Exception{
    assertEquals("Generator{}", g.toString());
  }

}