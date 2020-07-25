package problem02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import problem01.NonProfit;

/**
 * Catalog class representing a list of items
 */
public class Catalog {

  private List<AbstractItems> items;

  public Catalog() {
    this.items = new ArrayList<>();
  }

  /**
   * Get the collection of items
   * @return the collection of items
   */
  public List<AbstractItems> getItems() {
    return this.items;
  }

  /**
   * Add new items into the collection
   * @param abstractItems add abstract Items
   */
  public void addItems(AbstractItems abstractItems) {
    this.items.add(abstractItems);
  }

  /**
   * Search items by keyword
   * @param keyword keyword
   * @return a list of items containing this key word
   */
  public ArrayList<AbstractItems> search(String keyword) {
    ArrayList<AbstractItems> containWord = new ArrayList<AbstractItems>();
    for (AbstractItems item : items) {
      if (item.isMatch(keyword)) {
        containWord.add(item);
      }
    }
    return containWord;
  }

  /**
   * Search item by author
   * @param author author
   * @return a list of items that exactly match the given author
   */
  public ArrayList<AbstractItems> search(Author author) {
    ArrayList<AbstractItems> authorItems = new ArrayList<AbstractItems>();
    for (AbstractItems item : items) {
      if (item.isMatch(author)) {
        authorItems.add(item);
      }
    }
    return authorItems;
  }


  /**
   * Search item by artists
   * @param artist artists
   * @return a list of items that exactly match the given artists
   */
  public ArrayList<AbstractItems> search(RecordingArtist artist) {
    ArrayList<AbstractItems> artistCollection = new ArrayList<AbstractItems>();
    for (AbstractItems item : items) {
      if (item.isMatch(artist)){
        artistCollection.add(item);
      }
    } return artistCollection;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Catalog catalog = (Catalog) o;
    return Objects.equals(getItems(), catalog.getItems());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getItems(), getItems());
  }

}