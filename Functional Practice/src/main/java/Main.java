import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import finalPractice7.problem03.MainRE;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) throws Exception {
    List<String> res = new ArrayList<>();
    String test = "aAaAaA";
    Pattern a = Pattern.compile("(a)", Pattern.CASE_INSENSITIVE);
    Matcher m = a.matcher(test);
    while (m.find()){
      res.add(m.group(1));}
    System.out.println(res);
//      System.out.println(test.substring(m.start(), m.end()));
    }

//    String test = "aAaAaA";
//    Pattern a = Pattern.compile("^[aeiouAEIOU].*");
//    Matcher m = a.matcher(test);
//    System.out.println(m.matches());

//    System.out.println(MainRE.checkMatch("13456789"));
//    System.out.println(MainRE.checkMatch("pas$s$6789"));
//    System.out.println(MainRE.checkMatch("00pas$s$6789"));
//    Book b1 = new Book("A book", "An author", 1990, 4.999f);
//    Book b2 = new Book("A book2", "An author", 1991, 8.99f);
//    Book b3 = new Book("A book3", "An author", 1994, 6.99f);
//    Book b4 = new Book("A book4", "An author", 1998, 12.99f);
//    List<Book> finalCheatSheet.books = new ArrayList<>(Arrays.asList(b1, b2, b3, b4));
//    // Exercise 1
//
//    // 1. Make a new List containing only finalCheatSheet.books published before a certain date
//
//    List<Book> filterBookByYear = finalCheatSheet.books.stream().filter(book -> book.getYear() < 1994).collect(Collectors.toList());
//    System.out.println(filterBookByYear);
//
//    // 2. Make a new List containing only finalCheatSheet.books in a particular price range
//
//    List<Book> filterBookByPriceRange = finalCheatSheet.books.stream().filter(book -> book.getYear() > 1990 && book.getYear() < 1998).collect(
//        Collectors.toList());
//    System.out.println(filterBookByPriceRange);
//
//    // 3. Get the total price of all finalCheatSheet.books in the list
//    double total = finalCheatSheet.books.stream().mapToDouble(book -> book.getPrice()).sum();
//
//    // 4. Get the average price of all finalCheatSheet.books in the list
//    OptionalDouble averate = finalCheatSheet.books.stream().mapToDouble(book -> book.getPrice()).average();
//
//    List<Book> salesBooks = finalCheatSheet.books.stream().filter(book -> book.getYear() <= 1994)
//                                          .map(book -> {
//                                            book.setPrice(book.getPrice()*0.9f);
//                                            return book;
//                                              })
//                                          .collect(Collectors.toList());

//    List<String> lines = new ArrayList<>(Arrays.asList("aa", "bb", "ccc"));
//    List<String> res = lines.stream()
//        .filter(s -> s.length() < 6)
//        .collect(Collectors.toList());
//    System.out.println(res);
//    res.forEach(System.out::println);
//
//    System.out.println("===========");
//
//    List<String> captilizeWord = lines.stream()
//        .map(s -> s.toUpperCase())
//        .collect(Collectors.toList());
//    System.out.println(captilizeWord);

//    List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
//    int total = integers.stream().filter(i -> i % 2 == 0).mapToInt(integer -> integer).sum();
//    System.out.println(total);

//    List<String> strings = new ArrayList<>(Arrays.asList("1", "2", "12", "14", "15"));
//    int total = strings.stream().mapToInt(s -> Integer.parseInt(s))
//                    .filter(s -> s % 2 == 0)
//                    .sum();
//    System.out.println(total);
//    List<String> items = Arrays.asList("apple", "pear", "apple", "banana");
//    Map<String, Long> result = items.stream()
//                                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//    System.out.println(result);
//
//    Map<String, String> map = new HashMap<>();
//    map.put("A", "Jingjing");
//    map.put("B", "Kelly");
//
//    map

  }
//}
