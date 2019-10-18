import java.util.ArrayList;

public class SortLevel {
    public static boolean BubbleSortStep(int[] array){
        boolean swapped = true;
        int temp;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = false;
                }
            }
        return swapped;
    }

    public static void ShellSort(int[] array){
        ArrayList<Integer> list = KnuthSequence(array.length);
        for (int i = 0; i < list.size(); i++){
            for (int k = 0; k < list.get(i); k++){
                InsertionSortStep(array, list.get(i),k);
            }
        }
    }

    public static void SelectionSortStep(int[] array, int i){
        if (i+1 < array.length){
            int index = i+1;
            int min = array[index];
            for (int j = i+1; j < array.length; j++){
                if (min > array[j]){
                    min = array[j];
                    index = j;
                }
            }
            min = array[i];
            array[i] = array[index];
            array[index] = min;
        }
    }

//    public static void InsertionSortStep(int[] array, int step, int i) {
//        int temp;
//        int index = i;
//        for (int j = i; j < array.length; j += step) {
//            if (array[index] > array[j]) {
//                temp = array[j];
//                for (int k = j; k >= i; k -= step) {
//                    if (k - step >= i) {
//                        array[k] = array[k - step];
//                    }
//                }
//                array[i] = temp;
//            }
//            index = j;
//        }
//    }

    public static void InsertionSortStep(int[] array, int step, int i) {
        int temp;
        int index = i;
        for (int j = i; j < array.length; j += step) {
            if (array[index] > array[j]) {
                if (array[j] < array[i]) {
                    temp = array[j];
                    for (int k = j; k >= i; k -= step) {
                        if (k - step >= i) {
                            array[k] = array[k - step];
                        }
                    }
                    array[i] = temp;
                } else {
                    for (int k = j; k > i; k -= step){
                        if (((k - step) > i)&&(array[k] < array[k - step])){
                            temp = array[k-step];
                            array[k-step] = array[k];
                            array[k] = temp;
                        }
                    }
                }
            }
            index = j;
        }
    }

    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static ArrayList<Integer> KnuthSequence(int array_size) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while ((i = 3 * i + 1) <= array_size) {
            list.add(0, i);
        }
        return list;
    }

    public static void print(int[] array){
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int sequence(int iterator){
        if (iterator == 1){
            return 1;
        }else {
            return 3*sequence(iterator-1)+1;
        }
    }

    public static int ArrayChunk(int[] array){
        int i = 0;
        int j = array.length-1;
        int index = array.length/2;
        int frame = array[index];
        int temp;

        while (true){
            while (array[i] < frame){
                i++;
            }
            while (array[j] > frame){
                j--;
            }
            if ((i == (j - 1)) && (array[i] > array[j])){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (array[i] == frame){
                    index = i;
                }else if (array[j] == frame){
                    index = j;
                }
                i = 0;
                j = array.length/2;
            } else if ((i == j) || ((array[i] < array[j]) && i == j - 1)){
                return index;
            }else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (array[i] == frame){
                    index = i;
                }else if (array[j] == frame){
                    index = j;
                }
            }
        }
    }
}
