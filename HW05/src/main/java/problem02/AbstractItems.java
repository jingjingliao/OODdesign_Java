package problem02;

import java.util.Objects;

/**
 * Abstract items class including creator, title and year
 */
public abstract class AbstractItems {

  private AbstractCreator abstractCreator;
  String title;
  int year;

  /**
   * Constructs an abstract item class with creator, title and year
   * @param abstractCreator creator
   * @param title title
   * @param year year
   */
  public AbstractItems(AbstractCreator abstractCreator, String title, int year) {
    this.abstractCreator = abstractCreator;
    this.title = title;
    this.year = year;
  }

  /**
   * Get creator
   * @return creator
   */
  public AbstractCreator getAbstractCreator() {
    return abstractCreator;
  }

  /**
   * Get title
   * @return title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Get year
   * @return year
   */
  public int getYear() {
    return year;
  }

  /**
   * Check whether it matches the given keyword
   * @param keyword keyword
   * @return true if it matches otherwise false
   */
  public boolean isMatch(String keyword) {
    String lowercaseWord = keyword.toLowerCase();
    return this.getTitle().toLowerCase().contains(lowercaseWord);
  }

  /**
   * Check whether it matches the given author
   * @param author author
   * @return true if it matches, otherwise false
   */
  public abstract boolean isMatch (Author author);

  /**
   * Check whether it matches the given artists
   * @param artist artist
   * @return true if it matches, otherwise false
   */
  public abstract boolean isMatch (RecordingArtist artist);

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractItems abstractItems = (AbstractItems) o;
    return Objects.equals(getAbstractCreator(), abstractItems.getAbstractCreator()) &&
        (getYear() == abstractItems.getYear()) &&
        Objects.equals(getTitle(), abstractItems.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAbstractCreator(), getTitle(), getYear());
  }

}
