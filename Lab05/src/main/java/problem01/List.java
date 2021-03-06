package problem01;

/**
 * Represents a List of Integers
 */
public interface List {

  /**
   * Returns the total number of elements in the list.
   *
   * @return number of elements in this list
   */
  Integer size();


  /**
   * Returns true if empty and false otherwise
   *
   */
  Boolean isEmpty();

  /**
   * Given a new element {@code element} prepend it to this list
   *
   * @param element new element to add to the list
   * @return updated list with {@code element} prependeds
   */
  List add(Integer element);


  /**
   * Return the last element of this list.
   *
   * @return the last element of this list.
   */
  Integer last();

  boolean contain(Integer element);

  Integer elementAt(Integer index);

  List delete(Integer elem);
}
