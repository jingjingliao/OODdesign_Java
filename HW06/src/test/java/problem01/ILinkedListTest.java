package problem01.linkedlist01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem01.ElementNode;
import problem01.EmptyNode;
import problem01.ILinkedList;

public class ILinkedListTest {

  ILinkedList emptyList;
  ILinkedList oneItem;

  @Before
  public void setUp() throws Exception {
    emptyList = new EmptyNode();
    oneItem = new ElementNode(10, "10", new EmptyNode());
  }

  @Test
  public void count() {
    assertEquals(0, (int)emptyList.count());
    assertEquals(1, (int)oneItem.count());
  }

  @Test
  public void getItem() {
    assertTrue(oneItem.getItem().equals(10));
  }

  @Test
  public void getRest() {
    assertTrue(oneItem.getRest().equals(new EmptyNode()));
  }

  @Test
  public void getValue() {
    assertEquals("10", oneItem.getValue());
  }

  @Test
  public void insert() {
    ILinkedList twoItems = oneItem.insert(30, "30"); // insert at hear
    ILinkedList threeItems = twoItems.insert(15, "15"); // insert at middle
    ILinkedList fourItems = threeItems.insert(0, "0"); // insert at end

    ILinkedList newItems = new ElementNode(30, "30", new ElementNode(15, "15",
        new ElementNode(10, "10", new ElementNode(0, "0", new EmptyNode()))));
    assertTrue(fourItems.equals(newItems));
  }

  @Test
  public void testImmutability() {
    ILinkedList copyOneItem = oneItem;
    copyOneItem = copyOneItem.insert(20, "20");
    assertFalse(copyOneItem.equals(oneItem));
  }


  @Test
  public void equals() {
    assertTrue(emptyList.equals(new EmptyNode()));
    assertTrue(oneItem.equals(new ElementNode(10, "10", new EmptyNode())));
    assertFalse(emptyList.equals(oneItem));
    assertFalse(oneItem.equals(null));
  }

  @Test
  public void hashcode() {
    assertTrue(emptyList.hashCode() == new EmptyNode().hashCode());
    assertTrue(oneItem.hashCode() == new ElementNode(10, "10", new EmptyNode()).hashCode());
  }
}