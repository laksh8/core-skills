public class DoubleEndedQueue {
    private QueueNode head;
    private QueueNode tail;

    public DoubleEndedQueue(){
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int val){
        if (head == null){
            head = new QueueNode(val);
            tail = head;
            return;
        }
        QueueNode newHead = new QueueNode(val, head, null);
        head.prev = newHead;
        head = newHead;
    }

    // offer isn't needed because linked list implementation doesn't have a limit and isn't expected to throw that exception

    public void addLast(int val){
        if (tail == null){
            head = new QueueNode(val);
            tail = head;
            return;
        }
        QueueNode newTail = new QueueNode(val, null, tail);
        tail.next = newTail;
        tail = newTail;
    }

    public int peekLast(){
        if (tail == null){
            return -1;
        }
        return tail.value;
    }

    public int peekFirst(){
        if (head == null){
            return -1;
        }
        return head.value;
    }

    public int pollLast(){
        int toBeDeleted;
        if (head == null){
            return -1;
        }
        if (head.next == null){
            toBeDeleted = head.value;
            head = null;
            tail = null;
            return toBeDeleted;
        }
        toBeDeleted = tail.value;
        tail = tail.prev;
        tail.next = null;
        return toBeDeleted;
    }

    public int pollFirst(){
        int toBeDeleted;
        if (head == null){
            return -1;
        }
        if (head.next == null){
            toBeDeleted = head.value;
            head = null;
            tail = null;
            return toBeDeleted;
        }
        toBeDeleted = head.value;
        head = head.next;
        head.prev = null;
        return toBeDeleted;
    }

}

class QueueNode{
    int value;
    QueueNode next;
    QueueNode prev;

    public QueueNode(int value, QueueNode next, QueueNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    public QueueNode(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
