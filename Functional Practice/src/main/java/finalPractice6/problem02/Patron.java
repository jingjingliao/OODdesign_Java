package finalPractice6.problem02;

import java.util.ArrayList;
import java.util.List;

public class Patron extends Person {
  private List<Book> borrowedBooks = new ArrayList<>();
  /*
   * Constructs a Person object and initializes it
   * to the given first
   *
   * @param firstName
   * @param lastName
   * @param yearOfBirth the year of birth of this person
   * @param yearOfBirth the year of birth of this person
   */
  public Patron(String firstName, String lastName, int yearOfBirth, List<Book> borrowedBooks) {
    super(firstName, lastName, yearOfBirth);
    this.borrowedBooks = borrowedBooks;
  }
  /*
  Returns the list of books currently held by the user.
*/
  public List<Book> getBorrowedBooks() {
    return borrowedBooks;
  }
}
