public class Main {
    public static void main(String[] args){

        // trying out linked list features

        SinglyLinkedList sl = new SinglyLinkedList();
        sl.insertHead(1);
        sl.insertTail(2);
        sl.insertHead(0);

        sl.remove(1);

        System.out.println(sl.get(0));


        System.out.println(sl.getValues());

    }
}
