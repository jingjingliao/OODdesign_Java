package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sun.rmi.server.InactiveGroupException;

public class SetOfIntegersTest {
  SetOfIntegers empty;
  SetOfIntegers aset;
  SetOfIntegers sameSet;
  SetOfIntegers deleteTest;

  @Before
  public void setUp() throws Exception {
    empty = new SetOfIntegers();
    aset = new SetOfIntegers();
    sameSet = new SetOfIntegers();

    aset.add(3);
    aset.add(4);

    sameSet.add(4);
    sameSet.add(3);

  }

  @Test
  public void emptySet() {
    SetOfIntegers item = new SetOfIntegers();
    assertEquals(item, empty.emptySet());
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
  }

  @Test
  public void isNotEmpty() throws ElementAlreadyExistedException {
    aset.add(0);
    assertFalse(aset.isEmpty());
  }

  @Test
  public void add() throws ElementAlreadyExistedException {
    assertEquals(2, aset.size());
    aset.add(13);
    aset.add(14);
    assertEquals(4, aset.size());
    assertTrue(aset.contains(3));
    assertTrue(aset.contains(14));
  }


  @Test (expected = ElementAlreadyExistedException.class)
  public void addSameElement() throws ElementAlreadyExistedException {
    aset.add(23);
    aset.add(23);
  }

  @Test
  public void contains() {
    assertTrue(aset.contains(3));
    assertTrue(aset.contains(4));
  }

  @Test
  public void didNotContains() {
    assertFalse(aset.contains(10));
    assertFalse(aset.contains(20));
  }

  @Test
  public void removeFirst() throws ElementAlreadyExistedException {
    deleteTest = new SetOfIntegers();
    deleteTest.add(10);
    deleteTest.add(20);
    deleteTest.add(30);
    assertTrue(deleteTest.contains(10));
    assertTrue(deleteTest.contains(20));
    assertTrue(deleteTest.contains(30));
    assertEquals(3, deleteTest.size());

    SetOfIntegers item = new SetOfIntegers();
    item.add(30);
    item.add(20);
    assertEquals(item, deleteTest.remove(10));
  }

  @Test
  public void removeLast() throws ElementAlreadyExistedException {
    deleteTest = new SetOfIntegers();
    deleteTest.add(10);
    deleteTest.add(20);
    deleteTest.add(30);
    assertTrue(deleteTest.contains(10));
    assertTrue(deleteTest.contains(20));
    assertTrue(deleteTest.contains(30));
    assertEquals(3, deleteTest.size());

    SetOfIntegers item = new SetOfIntegers();
    item.add(10);
    item.add(20);
    assertEquals(item, deleteTest.remove(30));
  }


  @Test
  public void removeMiddle() throws ElementAlreadyExistedException {
    deleteTest = new SetOfIntegers();
    deleteTest.add(1);
    deleteTest.add(2);
    deleteTest.add(3);
    deleteTest.add(4);
    deleteTest.add(5);

    SetOfIntegers item = new SetOfIntegers();
    item.add(4);
    item.add(5);
    item.add(2);
    item.add(3);
    assertEquals(item, deleteTest.remove(1));
  }

  @Test
  public void NotInSetemove() throws ElementAlreadyExistedException {
    deleteTest = new SetOfIntegers();
    deleteTest.add(10);
    deleteTest.add(20);
    assertTrue(deleteTest.contains(10));
    assertTrue(deleteTest.contains(20));
    assertEquals(2, deleteTest.size());

    deleteTest.remove(5);
    assertTrue(deleteTest.contains(10));
    assertTrue(deleteTest.contains(20));
    assertEquals(2, deleteTest.size());
  }

  @Test
  public void size() throws ElementAlreadyExistedException {
    assertEquals(2, aset.size());
    aset.add(0);
    aset.add(1);
    assertEquals(4, aset.size());
  }

  @Test
  public void testEquals() throws ElementAlreadyExistedException {
    assertEquals(empty, empty);
    assertNotEquals(empty, aset);
    assertNotEquals(null, empty);
    assertNotEquals("", empty);
    assertEquals(sameSet, aset);
    assertNotEquals(aset, empty);
  }

  @Test
  public void testHashcode() {
    SetOfIntegers newObject = new SetOfIntegers();
    assertTrue(empty.hashCode() == newObject.hashCode());
  }
}