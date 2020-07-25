import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CSVDataReaderTest {
  CSVDataReader dataReader;
  CSVDataReader sameDataReader;

  @Before
  public void setUp() throws Exception {
    dataReader = new CSVDataReader();
    sameDataReader = new CSVDataReader();
  }

  @Test
  public void readTestTag() throws Exception {
    dataReader.read("testCSVFile.csv");
    List<String> testTag = new ArrayList<>();
    testTag.add("first_name");
    testTag.add("last_name");
    testTag.add("company_name");
    assertEquals(testTag, dataReader.tags);
  }

  @Test
  public void readTestInfo() throws Exception {
    dataReader.read("testCSVFile.csv");
    List<List<String>> testInfo = new ArrayList<>();
    List<String> individualOneInfo = new ArrayList<>();
    individualOneInfo.add("James");
    individualOneInfo.add("Butt");
    individualOneInfo.add("Benton, John B Jr");
    testInfo.add(individualOneInfo);

    List<String> individualTwoInfo = new ArrayList<>();
    individualTwoInfo.add("Simona");
    individualTwoInfo.add("Morasca");
    individualTwoInfo.add("Chapman, Ross E Esq");
    testInfo.add(individualTwoInfo);

    assertEquals(testInfo, dataReader.info);
  }

  @Test (expected = FileNotFoundException.class)
  public void fileNotFoundException() throws Exception {
    dataReader.read("test1CSVFile.csv");
  }

  @Test (expected = InvalidContentException.class)
  public void emptyException() throws Exception {
    dataReader.read("emptyFile.csv");
  }

  @Test (expected = InvalidContentException.class)
  public void containDuplicateInTags() throws Exception {
    dataReader.read("testCSVFileWithDuplicateTags.csv");
  }

  @Test
  public void testEquals() throws Exception {
    CSVDataReader diffdataReader = new CSVDataReader();
    diffdataReader.read("testCSVFile.csv");
    assertTrue(dataReader.equals(dataReader));
    assertFalse(dataReader.equals(null));
    assertFalse(dataReader.equals(new CSVDataReader()));
    assertNotNull(dataReader);
    assertTrue(dataReader.tags.equals(sameDataReader.tags));
    assertFalse(dataReader.tags.equals(diffdataReader.tags));
    assertTrue(dataReader.info.equals(sameDataReader.info));
    assertFalse(dataReader.info.equals(diffdataReader.info));
  }

  @Test
  public void testHashCode() {
    assertTrue(dataReader.hashCode() == sameDataReader.hashCode());
  }

  @Test
  public void testToString() throws Exception {
    dataReader.read("testCSVFile.csv");
    assertEquals("CSVDataReader{tags=[first_name, last_name, company_name], "
        + "info=[[James, Butt, Benton, John B Jr], "
        + "[Simona, Morasca, Chapman, Ross E Esq]]}", dataReader.toString());
  }
}