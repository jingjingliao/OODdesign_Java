package problem02;

import java.util.Objects;

/**
 * An immutable Bag of words class
 */
public class BagOfWords implements IBagOfWords {
  private final ILinkedListForWords bagOfWord;

  /**
   * Private constructor for an empty Bag of words class.
   */
  private BagOfWords(){
    this.bagOfWord = new EmptyNodeForWord();
  }

  /**
   * Private constructor for a Bag of words that contains elements.
   * @param bagOfWord The words in bag
   */
  private BagOfWords(ILinkedListForWords bagOfWord) {
    this.bagOfWord = bagOfWord;
  }

  /**
   * Creat an empty Bag of words
   * @return an empty Bag of words
   */
  public static BagOfWords emptyBagOfWords() {
    return new BagOfWords();
  }

  /**
   * Check whether the Bag of words is empty
   * @return true if it is empty, otherwise false
   */
  @Override
  public Boolean isEmpty() {
    return this.bagOfWord.count().equals(0);
  }

  /**
   * Gets the number of items in the Bag of words.
   * @return The number of items in the Bag of words.
   */
  @Override
  public Integer size() {
    return this.bagOfWord.count();
  }

  /**
   * Add a string into Bag of words
   * @param s the word add to the Bag of words
   * @return a new Bag of words with new String word
   */
  @Override
  public BagOfWords add(String s) {
    ILinkedListForWords words = this.bagOfWord.insert(s);
    return new BagOfWords(words);
  }

  /**
   * Check whether it conatains a specific word
   * @param s a String s
   * @return true if it contains, otherwise false
   */
  @Override
  public Boolean contains(String s) {
    return this.bagOfWord.contains(s);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BagOfWords that = (BagOfWords) o;
    return Objects.equals(bagOfWord, that.bagOfWord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bagOfWord);
  }

  @Override
  public String toString() {
    return "BagOfWords{" +
        "bagOfWord=" + bagOfWord +
        '}';
  }
}
