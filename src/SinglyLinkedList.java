import java.util.ArrayList;
class ListNode{
    int val;
    ListNode next;

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private ListNode head;
    private ListNode tail;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public int get (int index){
        if (head == null){
            return -1;
        }
        ListNode traversal = head;
        int value = traversal.val;

        try {
            for (int i = 0; i < index; i++){
                value = traversal.next.val;
                traversal = traversal.next;
            }
            return value;
        } catch (NullPointerException e){
            return -1;
        }
    }

    public void insertHead(int val){
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else{
            ListNode newHead = new ListNode(val, head);
            head = newHead;
        }
    }

    public void insertTail(int val){
        if (tail == null){
            insertHead(val);
            return;
        }
        ListNode newTail = new ListNode(val);
        tail.next = newTail;
        tail = newTail;
    }

    public ArrayList<Integer> getValues(){

        if (head == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> values = new ArrayList<>();
        ListNode traversal = head;

        values.add(traversal.val);

        while (traversal.next != null){
            values.add(traversal.next.val);
            traversal = traversal.next;
        }
        return values;
    }

    public boolean remove(int index){
        if (head == null){
            return false;
        }
        ListNode traversal = head;
        int count = 0;

        if (index == count){
            if (head.next != null){
                head = head.next;
            } else {
                head = null;
            }
            return true;
        }

        while (traversal != tail){
            count++;
            if (count == index){
                if (traversal.next == tail){
                    traversal.next = null;
                    tail = traversal;
                } else {
                    traversal.next = traversal.next.next;
                }
                return true;
            }
            traversal = traversal.next;
        }
        return false;
    }
}

