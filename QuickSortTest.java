  import org.junit.Test;

  import java.util.ArrayList;
  import java.util.Arrays;

  import static org.junit.Assert.*;

  public class SortLevelTest {

      @Test
      public void arrayChunk() {

      }

      @Test
      public void test(){
          int[] array = {5,6,7,4,1,2,3};//5,6,7,4,1,2,3
          System.out.println(Arrays.toString(array));
          ArrayList<Integer> list =  KthOrderStatisticsStep(array, 0,6,0);
          System.out.println(Arrays.toString(array));
  //        System.out.println(list);
          assertEquals(2, list.size());
          assertEquals(1, array[0]);
          assertEquals(2,array[1]);
          assertEquals(3, array[2]);
          assertEquals(4,array[3]);
          assertEquals(7,array[4]);
          assertEquals(6,array[5]);
          assertEquals(5, array[6]);
      }

      public static int ArrayChunk(int[] array, int left, int right){
          int i = left;
          int j = right;
          int index = (left+right)/2;
          int frame = array[index];
          int temp;
          boolean goTo = false;
          while (true) {
              if (goTo) {
                  i = left;
                  j = right;
                  index = (left+right)/2;
                  frame = array[index];
                  goTo = false;
              }
              while (array[i] < frame) {
                  i++;
              }
              while (array[j] > frame) {
                  j--;
              }
              if ((i == (j - 1)) && (array[i] > array[j])) {
                  temp = array[i];
                  array[i] = array[j];
                  array[j] = temp;
                  if (array[i] == frame) {
                      index = i;
                  } else if (array[j] == frame) {
                      index = j;
                  }
                  goTo = true;
              } else if ((i == j) || ((array[i] < array[j]) && i == j - 1)) {
                  return index;
              } else {
                  temp = array[i];
                  array[i] = array[j];
                  array[j] = temp;
                  if (array[i] == frame) {
                      index = i;
                  } else if (array[j] == frame) {
                      index = j;
                  }
              }
          }
      }

      public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k ){
          ArrayList<Integer> list = new ArrayList<>();
          while (true){
              int pivot = ArrayChunk(Array, L, R);
              if (pivot == k){
                  list.add(L);
                  list.add(R);
                  return list;
              }else if (pivot > k){
                  R = pivot - 1;
              }
              else {
                  L = pivot + 1;
              }
          }
      }

  }
