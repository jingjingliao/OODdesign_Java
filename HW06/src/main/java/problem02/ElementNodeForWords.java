package problem02;

import java.util.Objects;

/**
 * The element node which includes String word and the rest
 */
public class ElementNodeForWords implements ILinkedListForWords {
  private String word;
  private ILinkedListForWords rest;

  /**
   * Construct an element node with word and rest
   * @param word String word
   * @param rest linkedlist rest
   */
  public ElementNodeForWords(String word,  ILinkedListForWords rest){
    this.word = word;
    this.rest = rest;
  }

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {
    return 1 + this.rest.count();
  }

  /**
   * Get the word at the head of the list.
   * @return The String word at the head of the list or null if the list is empty.
   */
  @Override
  public String getWord() {
    return this.word;
  }

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedListForWords getRest() {
    return this.rest;
  }


  /**
   * insert an element at the head of a list
   * @param word String word
   * @return a new linkedlist with new item in front
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
    if (this.word == null)
      return false;
    if (this.word.equals(s))
      return true;
    else {
      return this.rest.contains(s);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ElementNodeForWords that = (ElementNodeForWords) o;
    return Objects.equals(word, that.word) &&
        Objects.equals(rest, that.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word, rest);
  }

  @Override
  public String toString() {
    return "ElementNode{" +
        "word='" + word + '\'' +
        ", rest=" + rest +
        '}';
  }
}
