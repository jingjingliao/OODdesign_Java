package finalCheatSheet.books;

import java.util.Objects;

public class Book implements Comparable<Book> {
  private String title;
  private String author;
  private int year;
  private float price;

  public Book(String title, String author, int year, float price) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public String toString(){
    return String.format("Title: %s Author: %s Year: %d Price: %.2f", this.title, this.author, this.year, this.price);
  }

  public boolean before(int year){
    return this.year < year;
  }

  public boolean cheaperThan(Book book){
    return this.price < book.getPrice();
  }



  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Book))
      return false;
    Book other = (Book) o;
    return this.title.equals(other.getTitle())
        && (this.year == other.getYear());
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, year, price);
  }

  @Override
  public int compareTo(Book book) {
    if (this.equals(book))
      return 0;
    if (this.title.compareTo(book.title) < 0)
      return -1;
    if (this.title.compareTo(book.title) == 0 && this.year < book.year)
      return -1;
    return 1;
  }
}
