package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Henry", "B", "White");
  }

  @Test
  public void getFirstName() {
    assertEquals("Henry", name.getFirstName());
  }

  @Test
  public void getMiddleName() {
    assertEquals("B", name.getMiddleName());
  }

  @Test
  public void getLastName() {
    assertEquals("White", name.getLastName());
  }

  @Test
  public void setFirstName() {
    name.setFirstName("AAA");
    assertEquals("AAA", name.getFirstName());
  }

  @Test
  public void setMiddleName() {
    name.setMiddleName("pp");
    assertEquals("pp", name.getMiddleName());
  }

  @Test
  public void setLastName() {
    name.setLastName("Black");
    assertEquals("Black", name.getLastName());
  }
}