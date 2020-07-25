package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
  Name name;
  Author author;
  Book book;
  Book sameBook;

  RecordingArtist artist;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jingjing", "Lee");
    author = new Author(name);
    book = new Book(author, "Moon", 2012);
    sameBook = new Book(author, "Moon", 2012);

    artist = new RecordingArtist(name);
  }

  @Test
  public void getCreator() {
    assertEquals(author, book.getAbstractCreator());
  }

  @Test
  public void getTitle() {
    assertEquals("Moon", book.getTitle());
  }

  @Test
  public void getYear() {
    assertEquals(2012, book.getYear());
  }

  @Test
  public void isMatch() {
    Author newAuthor = new Author(name);
    assertTrue(book.isMatch(newAuthor));
  }

  @Test
  public void isNotMatch() {
    Name name = new Name("Jingjing", "White");
    Author newAuthor = new Author(name);
    assertFalse(book.isMatch(newAuthor));
  }

  @Test
  public void testEquals() {
    Name name = new Name("Jingjing", "White");
    Author newAuthor = new Author(name);
    Book newBook = new Book(newAuthor, "Moon", 1990);

    assertEquals(book, sameBook);
    assertNotEquals(book, newBook);
    assertEquals(book, book);
    assertNotEquals(null, book);
  }

  @Test
  public void testHashCode() {
    assertEquals(book.hashCode(), sameBook.hashCode());
  }

  @Test
  public void testIsMatch1() {
    assertFalse(book.isMatch(artist));
  }
}