package problem02;

/**
 * Required operations for a linked list of Strings words
 */
public interface ILinkedListForWords {
  /**
   * Gets the number of elements in the list.
   * @return THe number of elements in the list.
   */
  Integer count();

  /**
   * Get the word at the head of the list.
   * @return The String at the head of the list or null if the list is empty.
   */
  String getWord();

  /**
   * Get the rest of the list.
   * @return The rest of the list or null if the list is empty.
   */
  ILinkedListForWords getRest();

  /**
   * Inserts an element into the list.
   * @param word word that needs to be inserted into list
   * @return a new linkedlist
   */
  ILinkedListForWords insert(String word);

  /**
   * Check whether it conatains a specific word
   * @param s a String s
   * @return true if it contains, otherwise false
   */
  Boolean contains(String s);

}
