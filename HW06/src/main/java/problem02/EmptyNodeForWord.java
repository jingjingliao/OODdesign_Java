package problem02;

/**
 * Empty node
 */
public class EmptyNodeForWord implements ILinkedListForWords {

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Get the word at the head of the list.
   *
   * @return The String word at the head of the list or null if the list is empty.
   */
  @Override
  public String getWord() {
    return null;
  }

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedListForWords getRest() {
    return null;
  }

  /**
   * Inserts an element at the head of the list.
   * @param word String word
   * @return a new linkedlist with a new item in the front
   */
  @Override
  public ILinkedListForWords insert(String word) {
    return new ElementNodeForWords(word, this);
  }

  /**
   * Check whether it conatains a specific word
   * @param s a String s
   * @return true if it contains, otherwise false
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }

  @Override
  public int hashCode() {
    return 31; // No fields so we have to make something up!
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    return obj != null && getClass() == obj.getClass();
  }

  @Override
  public String toString() {
    return "EmptyNode";
  }

}
