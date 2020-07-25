package problem02;

/**
 * A set represents an unordered collection of integers
 */
public interface ISetOfIntegers {

  /**
   * Creat an empty set
   * @return an empty set
   */
  ISetOfIntegers emptySet();

  /**
   * Check whether the set is empty or not
   * @return true if set is empty, otherwise false
   */
  Boolean isEmpty();


  /**
   * Add an item to the set
   * @param n the item to add
   * @throws ElementAlreadyExistedException if the element has already in the set,
   * throw an exception
   */
  void add(Integer n) throws ElementAlreadyExistedException;

  /**
   * check whether n is in the set
   * @param n check whether n is in the set
   * @return true if n is in the set otherwise false
   */
  Boolean contains(Integer n);

  /**
   * Remove an element in the set
   * @param n remove n in the set
   * @return return ISetOfIntegers
   */
  ISetOfIntegers remove(Integer n);

  /**
   * The number of items in the set
   * @return the number of items in the set
   */
  int size();
}
