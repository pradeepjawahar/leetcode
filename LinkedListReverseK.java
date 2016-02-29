public class LinkedListReverseK {

    class Node {
        int data;
        Node next = null;

        Node (int d) {
            data = d;
            next = null;
        }
    }
    private Node reverseK(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;
        while(count < k & current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = current.next;
            count++;
        }
        if (next != null) {
            reverseK(current,k);
        } 
        return prev;
    }

}

