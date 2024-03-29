public class HeapSort {

    public Heap HeapObject;

    public HeapSort(int[] array){
        HeapObject = new Heap(array);
    }

    public int GetNextMax(){
        return HeapObject.GetMax();
    }
    
}

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap(int[] array) {
        MakeHeap(array);
    }

    public void MakeHeap(int[] a) {
        HeapArray = new int[a.length];
        for (int i = 0; i < HeapArray.length; i++) HeapArray[i] = -1;
        for (int i = 0; i < a.length; i++) {
            Add(a[i]);
        }
    }

    public int GetMax() {
        // вернуть значение корня и перестроить кучу
        int max;
        if (HeapArray[0] == -1) {
            return -1;
        } else {
            max = HeapArray[0];
            HeapArray[0] = HeapArray[HeapArray.length-1];
            HeapArray[HeapArray.length-1] = -1;
            int i = 0;
            boolean greater = false;
            while (i < HeapArray.length && !greater) {
                if (2 * i + 1 < HeapArray.length) {
                    int node = Math.max(HeapArray[2 * i + 1], HeapArray[2 * i + 2]);
                    if (node > HeapArray[i]) {
                        int br = HeapArray[i];
                        if (node == HeapArray[2 * i + 1]) {
                            HeapArray[i] = node;
                            i = 2 * i + 1;
                        } else if (node == HeapArray[2 * i + 2]) {
                            HeapArray[i] = node;
                            i = 2 * i + 2;
                        }
                        HeapArray[i] = br;
                    }else {
                        greater = true;
                    }
                }else {
                    i = HeapArray.length;
                }
            }
        }
        return max;
    }

    public boolean Add(int key) {
        // добавляем новый элемент key в кучу и перестраиваем её
        if (HeapArray[0] == -1) {
            HeapArray[0] = key;
            return true;
        } else {
            for (int i = 1; i < HeapArray.length; i++) {
                if (HeapArray[i] == -1) {
                    HeapArray[i] = key;
                    for (; i >= 0; ) {
                        if (HeapArray[i] > HeapArray[(i - 1) / 2]) {
                            int temp = HeapArray[(i - 1) / 2];
                            HeapArray[(i - 1) / 2] = HeapArray[i];
                            HeapArray[i] = temp;
                        }
                        if (i == 0) {
                            return true;
                        }
                        i = (i - 1) / 2;
                    }
                }
            }
        }
        return false; // если куча вся заполнена
    }
    
}
