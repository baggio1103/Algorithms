public class SortLevel{ 
    public static boolean BubbleSortStep(int[] array){
        boolean swapped = true;
        int temp;
        for (int i = 0; i < array.length-1; i++){
            if (array[i] > array[i+1]){
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                swapped = false;
            }
        }
        return swapped;
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
}
