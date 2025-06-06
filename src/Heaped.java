import java.util.Arrays;

public class Heaped {

    private int[] arr;

    Heaped(int[] arr){

        this.arr = arr;

        buildMinHeap();

    }

    public void displayHeap(){

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    public void buildMinHeap(){

        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--){

            heapify(n, i);

        }

    }

    public void heapify(int n, int i){

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest]){

            smallest = left;

        }

        if (right < n && arr[right] < arr[smallest]){

            smallest = right;

        }

        if (smallest != i){

            swap (arr, i, smallest);
            heapify(n, smallest);

        }

    }
    

    private int[] swap(int[] arr, int i1, int i2){

        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

        return arr;

    }

}
