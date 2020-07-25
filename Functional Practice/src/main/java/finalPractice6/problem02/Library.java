package finalPractice6.problem02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Library {
  private Map<Book, Integer> borrowedBooks = new HashMap<>();

  public Library(Map<Book, Integer> borrowedBooks){
    this.borrowedBooks = borrowedBooks;
  }

  public Map<Book, Integer> getBorrowedBooks() {
    return borrowedBooks;
  }

  public static Map<Book, Integer> getAggregatedStatistics(List<Patron> patrons){
    Map<Book, Integer> borrowedBooksInfo = new HashMap<>();
    for (Patron patron: patrons){
      for (Book book: patron.getBorrowedBooks()){
        borrowedBooksInfo.putIfAbsent(book, 1);
        borrowedBooksInfo.put(book, borrowedBooksInfo.get(book) + 1);
      }
    }
    return borrowedBooksInfo;
  }
}
