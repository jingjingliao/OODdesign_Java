package problem02;

/**
 * Book class
 */
public class Book extends AbstractItems {

  /**
   * Construct a book with creator, title and year
   * @param author author
   * @param title title
   * @param year year
   */
  public Book(Author author, String title, int year) {
    super(author, title, year);
  }


  /**
   * Check whether the author matches the given author
   * @param author author
   * @return true if it matches, otherwise false
   */
  @Override
  public boolean isMatch(Author author) {
    return super.getAbstractCreator().equals(author);
  }

  /**
   * Check whether matches the given artist
   * @param artist artists
   * @return always false
   */
  @Override
  public boolean isMatch(RecordingArtist artist) {
    return false;
  }

}
