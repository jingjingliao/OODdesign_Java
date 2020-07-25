import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class TemplateDataReaderTest {
  TemplateDataReader dataReader;
  TemplateDataReader sameDataReader;

  @Before
  public void setUp() throws Exception {
    dataReader = new TemplateDataReader();
    sameDataReader = new TemplateDataReader();
  }

  @Test
  public void readTestTag() throws Exception {
    dataReader.read("test-email-template.txt");
    Set<String> testTag = new HashSet<>();
    testTag.add("first_name");
    testTag.add("last_name");
    testTag.add("email");
    assertEquals(testTag, dataReader.tags);
  }

  @Test
  public void readTestTemplate() throws Exception {
    dataReader.read("test-email-template.txt");
    List<String> testTemplate = new ArrayList<>();
    testTemplate.add("To:[[email]]");
    testTemplate.add("Subject: Spring sale!");
    testTemplate.add("Dear [[first_name]] [[last_name]]");
    assertEquals(testTemplate, dataReader.template);
  }

  @Test (expected = FileNotFoundException.class)
  public void fileNotFoundException() throws Exception {
    dataReader.read("email-tem");
  }

  @Test (expected = IOException.class)
  public void IOEException() throws Exception {
    dataReader.read("email-tem@");
  }

  @Test
  public void testEquals() throws Exception {
    assertEquals(dataReader, dataReader);
    assertNotEquals(null, dataReader);
    assertNotEquals(dataReader, new TemplateDataReader());
    assertNotNull(dataReader);
    assertEquals(dataReader.tags, sameDataReader.tags);
    assertEquals(dataReader.template, sameDataReader.template);
  }

  @Test
  public void testHashCode() {
    assertTrue(dataReader.hashCode() == sameDataReader.hashCode());
  }

  @Test
  public void testToString() throws Exception {
    dataReader.read("test-email-template.txt");
    assertEquals("TemplateDataReader{tags=[last_name, first_name, email], "
        + "template=[To:[[email]], Subject: Spring sale!, "
        + "Dear [[first_name]] [[last_name]]]}", dataReader.toString());
  }
}