package finalPractice7.problem02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FlattenListTest {
  FlattenList flattenList;
  List<List<Integer>> list;
  List<Integer> list1;
  List<Integer> list2;
  List<Integer> list3;

  @Before
  public void setUp() throws Exception {
    flattenList = new FlattenList();
    list = new ArrayList<>();

    list1 = new ArrayList<>(Arrays.asList(1,2,5));
    list2 = new ArrayList<>(Arrays.asList(3, 5));
    list3 = new ArrayList<>(Arrays.asList(10,20,6));

    list.add(list1);
    list.add(list2);
    list.add(list3);

  }

  @Test
  public void testEmpty() {
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> emptyList = new ArrayList<>();
    emptyList.add(res);
    assertEquals(flattenList.flatten(emptyList), res);
  }

  @Test
  public void testNoDuplicate() {
    List<Integer> res = new ArrayList<>(Arrays.asList(-5, -10, -20));
    assertEquals(flattenList.flatten(list), res);
  }

  @Test
  public void testDuplicate() {
    List<Integer> res = new ArrayList<>(Arrays.asList(-5, -10, -20, -15));
    List<Integer> addDuplicate = new ArrayList<>(Arrays.asList(15, 15, 15));
    list.add(addDuplicate);
    assertEquals(flattenList.flatten(list), res);
  }


}