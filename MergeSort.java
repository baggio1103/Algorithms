import java.util.ArrayList;
public class MergeSort {
    
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> array){
        System.out.println(array);
        sort(array, 0, array.size()-1);
        System.out.println(array);
        return array;
    }

    public static void sort(ArrayList<Integer> array, int left, int right){
        if (right > left){
            int middle = (left + right)/2;
            sort(array, left, middle);
            sort(array, middle+1, right);
            merge(array, left, middle, right);
        }
    }

    public static void merge(ArrayList<Integer> array, int left, int middle, int right){
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftSubArray = new int[leftSize];
        int[] rightSubArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++){
            leftSubArray[i] = array.get(left+i);
        }

        for (int i = 0; i < rightSize; i++){
            rightSubArray[i] = array.get(middle+i+1);
        }
        /* i and j are initial indices of left and right subArrays respectively*/
        int i = 0, j = 0;
        int k = left; //initial index used to merge two subArrays
        while (i < leftSize && j < rightSize){
            if (leftSubArray[i] <= rightSubArray[j]){
                array.set(k, leftSubArray[i]);
                i++;
            } else{
                array.set(k, rightSubArray[j]);
                j++;
            }
            k++;
        }

        while (i < leftSize){
            array.set(k, leftSubArray[i]);
            i++;
            k++;
        }

        while (j < rightSize){
            array.set(k,rightSubArray[j]);
            k++;
            j++;
        }
    }

}
