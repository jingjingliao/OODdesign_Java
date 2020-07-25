package problem02;

/**
 * An immutable Bag of words ADT. This Bag of words will contain String words.  data structure.
 */
public interface IBagOfWords {

  /**
   * Check whether the Bag of words is empty
   * @return true if it is empty, otherwise false
   */
  Boolean isEmpty();

  /**
   * Gets the number of items in the Bag of words.
   * @return The number of items in the Bag of words.
   */
  Integer size();

  /**
   * Add a string into Bag of words
   * @param s the word add to the Bag of words
   * @return a new Bag of words with new String word
   */
  BagOfWords add(String s);

  /**
   * Check whether it conatains a specific word
   * @param s a String s
   * @return true if it contains, otherwise false
   */
  Boolean contains(String s);

}
