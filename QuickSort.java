public class SortLevel {
  public static void QuickSort(int[] array, int left, int right) {
        if (left == right){
            return;
        }else {
            int base = ArrayChunk(array, left, right);
            QuickSort(array, left, base-1);
            QuickSort(array, base+1, right);
        }
    }
  
  public static void QuickSortTailOptimization( int[] array, int left, int right ){
           while (left < right){
            int pivot = ArrayChunk(array, left, right);
            if (pivot - left < right - pivot){
                QuickSort(array, left, pivot-1);
                left = pivot + 1;
            }else {
                QuickSort(array, pivot+1, right);
                right = pivot-1;
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
