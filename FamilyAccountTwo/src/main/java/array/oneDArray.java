package array;

/*
1,  数组是有序排列的
2， 数组属于引用数据类型的变量，数组的元素 既可以是基本的数据类型 又可以是引用类型
3， 创建数组对象会在内存中开辟一整块的连续的空间
4， 数组的长度一旦确定 就不能修改
 */
public class oneDArray {
  public static void main(String[] args){
    // 静态初始化
    int[] ids = new int[]{1001, 1002, 1003, 1004};
    // 类型推断
    int[] newIds = {1001, 1002, 1003, 1004};
    // 动态初始化
    int[] nameId = new int[5];
    String[] names = new String[5];
  }

  // 静态初始化
  int[][] arr = new int[][]{{1,2,3}, {3,4,5}};
  // 类型推断
  int[][] arr1 = {{1,2,3}, {3,4,5}};
  // 动态初始化 行 列
  int[][] newArr = new int[2][3];
  int[][] newArr1 = new int[2][];
}
