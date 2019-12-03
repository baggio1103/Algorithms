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
        if (found == 0){
            if (Left > Right){
                found = -1;
            }else if(array[middle] == N) {
                found = 1;
            }else if (array[middle] > N){
                Right = middle - 1;
            }else if (array[middle] < N){
                Left = middle + 1;
            }
            if (Left == Right && array[Left] == N){
                found = 1;
            }else if (Left >= Right){
                found = -1;
            }
        }
    }

    public boolean GallopingSearch(int[] array, int N){
        int i = 1;
        int index = (int) (Math.pow(2,i) - 2);

        while (index < array.length){
            if (array[index] == N){
                found = 1;
                return true;
            }else if (array[index] < N){
                i++;
                index = (int) (Math.pow(2, i) - 2);
                if (index >= array.length){
                    Left = (int) (1 + Math.pow(2, (i-1)) - 2);
                    Right = array.length-1;
                }
            }else if (array[index] > N){
                index = array.length;
                Left = (int) (1 + Math.pow(2, (i-1)) - 2);
                Right = index;
            }
        }

        while (found == 0){
            Step(N);
        }

        return found == 1;
    }

    public int GetResult(){
        return found;
    }

}
