package problem01;

import static org.junit.Assert.*;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

public class IStackTest {
  IStack stack;
  IStack stack2;
  IStack emptyStack;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void push() {
    stack.push(5);
    stack.push(6);
    stack.push(7);
    assertEquals(Integer.valueOf(7), stack.top());
  }

  @Test
  public void pop() {
    stack.push(6);
    stack.push(7);
    stack.push(8);
    assertEquals(Integer.valueOf(8), stack.pop());
  }

  @Test (expected = EmptyStackException.class)
  public void invalidpop() throws EmptyStackException{
    emptyStack.pop();
  }

  @Test
  public void top(){
    stack2.push(5);
    stack2.push(6);
    stack2.push(10);
    assertEquals(Integer.valueOf(10), stack.top());
  }

  @Test (expected = EmptyStackException.class)
  public void invalidtop() throws EmptyStackException{
    emptyStack.top();
  }

  @Test
  public void wrongTop(){
    stack2.push(15);
    stack2.push(16);
    stack2.push(10);
    assertNotEquals(Integer.valueOf(15), stack.top());
  }

  @Test
  public void isEmpty() {
    assertTrue(emptyStack.isEmpty());
  }

  @Test
  public void isEmptyFalse() {
    stack.push(3);
    assertFalse(stack.isEmpty());
  }

}