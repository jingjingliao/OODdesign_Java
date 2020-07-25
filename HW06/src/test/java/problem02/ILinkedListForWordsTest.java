package problem02.linkedlist02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem02.ElementNodeForWords;
import problem02.EmptyNodeForWord;
import problem02.ILinkedListForWords;

public class ILinkedListForWordsTest {
  ILinkedListForWords emptyList;
  ILinkedListForWords oneItem;

  @Before
  public void setUp() throws Exception {
    emptyList = new EmptyNodeForWord();
    oneItem = new ElementNodeForWords("lee", new EmptyNodeForWord());
  }

  @Test
  public void count() {
    assertEquals(0, (int)emptyList.count());
    assertEquals(1, (int)oneItem.count());
  }

  @Test
  public void getWord() {
    assertEquals("lee", oneItem.getWord());
  }

  @Test
  public void getRest() {
    assertTrue(oneItem.getRest().equals(new EmptyNodeForWord()));
  }

  @Test
  public void insert() {
    ILinkedListForWords twoItems = oneItem.insert("weee");
    ILinkedListForWords threeItems = twoItems.insert("weee");

    ILinkedListForWords newItems = new ElementNodeForWords("weee", new ElementNodeForWords("weee", new ElementNodeForWords("lee", new EmptyNodeForWord())));
    assertTrue(threeItems.equals(newItems));
  }

  @Test
  public void contains() {
    assertTrue(oneItem.contains("lee"));
  }

  @Test
  public void notContains() {
    assertFalse(oneItem.contains("le"));
  }

  @Test
  public void testImmutability() {
    ILinkedListForWords copyOneItem = oneItem;
    copyOneItem = copyOneItem.insert("moon");
    assertFalse(copyOneItem.equals(oneItem));
  }


  @Test
  public void equals() {
    assertTrue(emptyList.equals(new EmptyNodeForWord()));
    assertTrue(oneItem.equals(new ElementNodeForWords("lee", new EmptyNodeForWord())));
    assertFalse(emptyList.equals(oneItem));
    assertFalse(oneItem.equals(null));
  }

  @Test
  public void hashcode() {
    assertTrue(emptyList.hashCode() == new EmptyNodeForWord().hashCode());
    assertTrue(oneItem.hashCode() == new ElementNodeForWords("lee", new EmptyNodeForWord()).hashCode());
  }

}