package finalPractice6.problem02;

/**
 *Class represents a book. A book has a title and an author
 */
public class Book {
  private String title;
  private Person author;
  /**
   * Construct a Book object that has the
   * provided title and author
   *
   * @param title the title to be given to this book
   * @param author the author to be given to this book */
  public Book(String title, Person author) {
    this.title = title;
    this.author = author;
  }
  /**
   * Return the title of this book
   * @return the title of this book
   */
  public String getTitle() {
    return this.title;
  }
  /**
   * Return the author of this object
   * @return the author of this object as a @link{Person}
   */
  public Person getAuthor() {
    return this.author;
  } }
