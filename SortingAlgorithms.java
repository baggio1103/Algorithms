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
                InsertionSortStep(array,list.get(i),k);
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

    public static void InsertionSortStep(int[] array, int step, int i) {
        int temp;
        int index = i;
        for (int j = i; j < array.length; j += step) {
            if (array[index] > array[j]) {
                temp = array[j];
                for (int k = j; k >= i; k -= step) {
                    if (k - step >= i) {
                        array[k] = array[k - step];
                    }
                }
                array[i] = temp;
            }
            index = j;
        }
    }

    public static ArrayList<Integer> KnuthSequence(int array_size){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < array_size;){
            list.add(0,i);
            i = 3*i+1;
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
    
}
