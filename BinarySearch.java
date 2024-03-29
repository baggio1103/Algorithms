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
        if (Left > Right){
            found = -1;
            return;
        }

        if (array[middle] == N) {
            found = 1;
            return;
        } else if (array[middle] > N) {
            Right = middle - 1;
        } else if (array[middle] < N) {
            Left = middle + 1;
        }
        Step(N);
    }

    public int GetResult(){
        return found;
    }
    
}
