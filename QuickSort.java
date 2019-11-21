import java.util.ArrayList;

public class SortLevel {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int factorial(int n, int a) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a;
        }
        return factorial(n - 1, n * a);
    }
    
    public static void print(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void QuickSortTailOptimization(int[] array, int left, int right) {
        while (left < right) {
            int pivot = ArrayChunk(array, left, right);
            QuickSortTailOptimization(array, left, pivot - 1);
            left = pivot + 1;
        }
    }

    public static void QuickSort(int[] array, int left, int right) {
        while (left < right) {
            int pivot = ArrayChunk(array, left, right);
            if (pivot - left < right - pivot) {
                QuickSort(array, left, pivot - 1);
                left = pivot + 1;
            } else {
                QuickSort(array, pivot + 1, right);
                right = pivot - 1;
            }
        }
    }

    public static int ArrayChunk(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int index = (left + right) / 2;
        int frame = array[index];
        int temp;
        boolean goTo = false;
        while (true) {
            if (goTo) {
                i = left;
                j = right;
                index = (left + right) / 2;
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

    public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int pivot = ArrayChunk(Array, L, R);
        if (pivot == k) {
            list.add(L);
            list.add(R);
            return list;
        } else if (pivot > k) {
            R = pivot - 1;
        } else {
            L = pivot + 1;
        }
        list.add(L);
        list.add(R);
        return list;
    }
    
}
