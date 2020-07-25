package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Alicia", "Lee");
  }

  @Test
  public void getFirstName() {
    assertEquals("Alicia", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Lee", name.getLastName());
  }
}