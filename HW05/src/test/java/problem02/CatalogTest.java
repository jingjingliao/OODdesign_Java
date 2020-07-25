package problem02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {
  Catalog catalog;
  Catalog sameCatalog;

  Book book;
  Name name;
  Author author;

  @Before
  public void setUp() throws Exception {

    name = new Name("Jingjing", "Lee");
    author = new Author(name);
    book = new Book(author, "Sunny", 2001);

    catalog = new Catalog();
    catalog.addItems(book);

    sameCatalog = new Catalog();
    sameCatalog.addItems(book);
  }

  @Test
  public void getItems() {
    assertEquals(book, catalog.getItems().get(0));
  }

  @Test
  public void addItems() {
    Book newBook = new Book(author, "Cloudy", 2000);
    catalog.addItems(newBook);
    assertEquals(newBook, catalog.getItems().get(1));
  }

  @Test
  public void searchKeyword() {
    Band band = new Band("Yoyo");
    Music bandMusic = new Music(band, "Sun", 2000);
    catalog.addItems(bandMusic);

    ArrayList<AbstractItems> collection = new ArrayList<>();
    collection.add(book);
    collection.add(bandMusic);

    assertEquals(collection ,catalog.search("Sun"));
  }

  @Test
  public void noSearchKeyword() {
    ArrayList<Book> collection = new ArrayList<>();
    assertEquals(collection ,catalog.search("Q"));
  }

  @Test
  public void testSearchSameAuthor() {
    Band band = new Band("Yoyo");
    Music bandMusic = new Music(band, "Sun", 2000);

    catalog.addItems(bandMusic);

    ArrayList<Book> collection = new ArrayList<>();
    collection.add(book);

    assertEquals(collection, catalog.search(author));
  }

  @Test
  public void testNoSearchSameAuthor() {
    RecordingArtist artist = new RecordingArtist(name);
    Music music = new Music(artist, "Spring", 1988);

    Catalog anotherCatalog = new Catalog();
    anotherCatalog.addItems(music);

    ArrayList<AbstractItems> collection = new ArrayList<>();
    assertEquals(collection, anotherCatalog.search(author));
  }


  @Test
  public void testSearchArtist() {
    RecordingArtist artist = new RecordingArtist(name);
    Music music = new Music(artist, "Spring", 1988);
    catalog.addItems(music);


    ArrayList<AbstractItems> collection = new ArrayList<>();
    collection.add(music);

    assertEquals(collection, catalog.search(artist));
  }

  @Test
  public void testEquals() {
    Catalog anotherCatalog = new Catalog();
    Book newBook = new Book(author, "Mandy", 2000);
    anotherCatalog.addItems(newBook);

    assertEquals(catalog, sameCatalog);
    assertEquals(catalog, catalog);
    assertNotEquals(catalog, anotherCatalog);
    assertNotEquals(null, catalog);
  }


  @Test
  public void testHashCode() {
    assertEquals(catalog.hashCode(), sameCatalog.hashCode());
  }
}