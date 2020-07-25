package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jingjing", "Lee");
  }

  @Test
  public void getFirstName() {
    assertEquals("Jingjing", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Lee", name.getLastName());
  }
}