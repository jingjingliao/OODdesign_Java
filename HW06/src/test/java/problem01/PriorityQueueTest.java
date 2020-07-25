package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {

  IPriorityQueue emptyQueue;
  IPriorityQueue threeQueue;
  IPriorityQueue oneQueue;

  @Before
  public void setUp() throws Exception {
    emptyQueue = PriorityQueue.creatEmpty();
    threeQueue = PriorityQueue.creatEmpty();
    oneQueue = PriorityQueue.creatEmpty();
    oneQueue = oneQueue.add(20,"20");
    threeQueue = threeQueue.add(10, "10");
    threeQueue = threeQueue.add(30, "30");
    threeQueue = threeQueue.add(20, "20");
  }

  @Test
  public void isEmpty() {
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void isNotEmpty() {
    IPriorityQueue copyQueue = emptyQueue.add(10, "10");
    assertFalse(copyQueue.isEmpty());
  }

  @Test
  public void size() {
    assertTrue(emptyQueue.size().equals(0));
  }

  @Test
  public void addSize() {
    assertTrue(threeQueue.size().equals(3));
  }


  @Test
  public void add() {
    emptyQueue = emptyQueue.add(10, "10");
    emptyQueue = emptyQueue.add(20, "20");
    emptyQueue = emptyQueue.add(30, "30");
    assertTrue(emptyQueue.equals(threeQueue));

  }

  @Test (expected = EmptyPriorityQueueException.class)
  public void invalidPeek() throws EmptyPriorityQueueException{
    emptyQueue.peek();
  }

  @Test
  public void peek() throws EmptyPriorityQueueException {
    assertEquals("30", threeQueue.peek());
  }

  @Test (expected = EmptyPriorityQueueException.class)
  public void invalidPop() throws EmptyPriorityQueueException {
    emptyQueue.pop();
  }

  public void pop() throws EmptyPriorityQueueException {
    IPriorityQueue elem = threeQueue.pop();
    assertTrue(elem.equals(oneQueue.add(10, "10")));

  }

  @Test
  public void testEquals() {
    assertTrue(threeQueue.equals(threeQueue));
    assertFalse(threeQueue.equals(null));
    assertFalse(threeQueue.equals(emptyQueue));
  }

  @Test
  public void testHashCode() {
    assertTrue(emptyQueue.hashCode() == PriorityQueue.creatEmpty().hashCode());
    emptyQueue = emptyQueue.add(10, "10");
    emptyQueue = emptyQueue.add(30, "30");
    emptyQueue = emptyQueue.add(20, "20");
    assertTrue(threeQueue.hashCode() == emptyQueue.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "PriorityQueue{pq=ElementNode{item=30value=30, rest=ElementNode{item=20value=20, rest=ElementNode{item=10value=10, rest=EmptyNode}}}}";
    assertEquals(expected, threeQueue.toString());
  }
}