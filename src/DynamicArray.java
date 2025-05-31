import java.util.Arrays;

class DynamicArray {
    private int[] arr;
    private int capacity;
    private int length;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {

        if (i >= length){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
        }

        return arr[i];
    }
    public void getAll(){
        for (int i = 0; i < length; i++){
            System.out.println(arr[i]);
        }
    }

    public void set(int i, int n) {
        while (i + 1 > capacity){ // needs to loop until gets enough
            resize();
        }
        if (i >= length){
            length = i + 1;
        }
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity){
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if (length == 0){
            throw new IllegalStateException("Array is empty");
        }
        length--;
        int popped = arr[length];
        arr[length] = 0;
        return popped;
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = Arrays.copyOf(arr, capacity);
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
