package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BagOfWordsTest {

  IBagOfWords emptyBag;
  IBagOfWords oneBagOfWords;

  @Before
  public void setUp() throws Exception {
    emptyBag = BagOfWords.emptyBagOfWords();
    oneBagOfWords = BagOfWords.emptyBagOfWords();
    oneBagOfWords = oneBagOfWords.add("word");
  }

  @Test
  public void isEmpty() {
    assertTrue(emptyBag.isEmpty());
  }

  @Test
  public void isNotEmpty() {
    assertFalse(oneBagOfWords.isEmpty());
  }

  @Test
  public void size() {
    assertTrue(oneBagOfWords.size().equals(1));
  }

  @Test
  public void add() {
    IBagOfWords twoBagOfWords;
    twoBagOfWords = BagOfWords.emptyBagOfWords();
    assertTrue(twoBagOfWords.size().equals(0));
    twoBagOfWords = BagOfWords.emptyBagOfWords();
    twoBagOfWords = twoBagOfWords.add("sun");
    twoBagOfWords = twoBagOfWords.add("moon");
    assertTrue(twoBagOfWords.size().equals(2));
  }

  @Test
  public void contains() {
    assertTrue(oneBagOfWords.contains("word"));
  }

  @Test
  public void notContains() {
    assertFalse(oneBagOfWords.contains("lee"));
  }

  @Test
  public void testEquals() {
    assertTrue(oneBagOfWords.equals(oneBagOfWords));
    assertFalse(oneBagOfWords.equals(null));
    assertFalse(oneBagOfWords.equals(emptyBag));
  }

  @Test
  public void testHashCode() {
    assertTrue(emptyBag.hashCode() == BagOfWords.emptyBagOfWords().hashCode());
    emptyBag = emptyBag.add("word");
    assertTrue(emptyBag.hashCode() == oneBagOfWords.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "BagOfWords{bagOfWord=ElementNode{word='word', rest=EmptyNode}}";
    assertEquals(expected, oneBagOfWords.toString());
  }

}