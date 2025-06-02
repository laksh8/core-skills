public class Main {
    public static void main(String[] args){

        // trying out double ended queue

        DoubleEndedQueue de = new DoubleEndedQueue();

        de.addFirst(5);
        de.addFirst(56);
        de.addLast(123);

        System.out.println( de.peekFirst());
        System.out.println( de.peekLast());

        System.out.println( de.pollFirst());
        System.out.println( de.pollLast());

        System.out.println( de.peekFirst());
        System.out.println( de.peekLast());

    }
}
