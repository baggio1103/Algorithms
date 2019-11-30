public class BinarySearch {

    public int Left;
    public int Right;
    public int found;
    public int[] array;

    public BinarySearch(int[] array){
        this.array = array;
        this.Left = 0;
        this.Right = array.length-1;
        found = 0;
    }

    public void Step(int N){
        int middle = (Right + Left) / 2;
        if (found == 0) {
            if (Left == Right && array[middle] != N) {
                found = -1;
            }
            if (array[middle] == N) {
                found = 1;
            } else if (array[middle] > N) {
                Right = middle - 1;
            } else if (array[middle] < N) {
                Left = middle + 1;
            }
            // in this point indices are fully formed
        }
    }

    public int GetResult(){
        if (found == 1){
            return 1;
        }else if (found == -1){
            return found;
        }else {
            return 0;
        }
    }

}
