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
                QuickSort(array, left, pivot-1, times++);
                left = pivot + 1;
            }else {
                QuickSort(array, pivot+1, right, times++);
                right = pivot-1;
            }
        }
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
}  
