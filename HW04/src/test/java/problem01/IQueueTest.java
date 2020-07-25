package problem01;

import static org.junit.Assert.*;

import java.util.Queue;
import org.junit.Before;
import org.junit.Test;

public class IQueueTest {
  IQueue queue;
  IQueue emptyQueue;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void enqueue() throws EmptyQueueException {
    assertEquals(Integer.valueOf(0), queue.size());
    Integer item = 4;
    queue.enqueue(item);
    assertEquals(Integer.valueOf(4), queue.front());
    assertEquals(Integer.valueOf(1), queue.size());
  }

  @Test
  public void dequeue() throws EmptyQueueException {
    queue.enqueue(5);
    queue.enqueue(4);
    queue.enqueue(3);
    assertEquals(Integer.valueOf(3), queue.size());
    Integer item = queue.dequeue();
    assertEquals(Integer.valueOf(5), item);
    assertEquals(Integer.valueOf(2), queue.size());
  }


  @Test (expected = EmptyQueueException.class)
  public void emptyDequeue() throws EmptyQueueException {
    emptyQueue.dequeue();
  }


  @Test
  public void front() throws EmptyQueueException {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertEquals(Integer.valueOf(1), queue.dequeue());
  }

  @Test (expected = EmptyQueueException.class)
  public void invalidFront() throws EmptyQueueException {
    emptyQueue.front();
  }


  @Test
  public void size() {
    assertEquals(Integer.valueOf(0), queue.size());
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertEquals(Integer.valueOf(3), queue.size());
  }
}