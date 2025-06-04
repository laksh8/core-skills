
/*

*  Hash map implementation, array of linked lists
*  hash function computes index, collision adds node to linked list
*  rehash when load factor increases

*/

public class HashedMap {

    private HashNode[] arr;
    private int arrLength;

    public int getSize() {
        return size;
    }

    public int getArrLength() {
        return arrLength;
    }

    private int size = 0;

    public HashedMap(int arrLength) {
        this.arrLength = arrLength;
        arr = new HashNode[this.arrLength];
    }

    private int hashFunction(int key){

        return key % arrLength;

    }

    public void insert(int key, int value){

        if ((float)size/arrLength > 1.2) reHash();

        int index = hashFunction(key);

        insertNode(key, value, index);

    }

    private void reHash() {

        arrLength *= 2;
        HashNode[] oldArr = arr;
        arr = new HashNode[arrLength];
        size = 0;

        while (true){

            HashNode element = popElement(oldArr);
            if (element == null) break;

            do {

                insertNode(element.key, element.value, hashFunction(element.key));
                element = element.next;

            } while (element != null);

        }

    }

    private HashNode popElement(HashNode[] arr){

        for (int i = 0; i < arr.length; i++){

            if (arr[i] == null) continue;

            HashNode temp = arr[i];
            arr[i] = null;

            return temp;

        }

        return null;

    }

    private void insertNode(int key, int value, int index) {

        HashNode newNode = new HashNode(key,value);
        HashNode traversal = arr[index];

        if (traversal == null) {

            arr[index] = newNode;
            size++;
            return;

        }

        if (traversal.key == key){

            traversal.value = value;
            return;

        }

        while (traversal.next != null) {

            traversal = traversal.next;

            if (traversal.key == key){

                traversal.value = value;
                return;

            }

        }

        traversal.next = newNode;
        size++;

    }

    public void displayMap(){

        for (HashNode node : arr){

            while (node != null){

                System.out.println(node.key + " -> " + node.value);

                node = node.next;

            }

        }

    }

    public int get(int key){

        int index = hashFunction(key);

        if (arr[index] == null) return -1;

        HashNode traversal = arr[index];

        while (traversal != null){

            if (traversal.key == key) return traversal.value;

            traversal = traversal.next;

        }

        return -1;

    }

    public void remove(int key) {

        int index = hashFunction(key);

        HashNode traversal = arr[index];

        if (traversal == null) return;

        if (traversal.key == key) {

            if (traversal.next == null){

                arr[index] = null;
                size--;
                return;

            }

            arr[index] = traversal.next;
            size--;
            return;

        }

        while (traversal.next != null){

            if (traversal.next.key == key){

                traversal.next = traversal.next.next;
                size--;
                return;

            }

            traversal = traversal.next;

        }


    }

}

class HashNode{

    int key;
    int value;
    HashNode next;

    HashNode(int key, int value){

        this.key = key;
        this.value = value;
        this.next = null;
    }

}


