package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
  Name name;
  Name diffName;
  Author author;
  Author sameAuthor;
  Author diffAuthor;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jingjing", "Lee");
    diffName = new Name("Jing", "Lee");
    author = new Author(name);

    sameAuthor = new Author(name);
    diffAuthor = new Author(diffName);
  }

  @Test
  public void getName() {
    assertEquals(name, author.getName());
  }

  @Test
  public void testEquals() {

    assertEquals(author, sameAuthor);
    assertNotEquals(author, diffAuthor);
    assertEquals(author, author);
    assertNotEquals(null, author);
  }

  @Test
  public void testHashCode() {
    assertEquals(author.hashCode(), sameAuthor.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("IndividualPeroson{name=JingjingLee}", author.toString());
  }
}