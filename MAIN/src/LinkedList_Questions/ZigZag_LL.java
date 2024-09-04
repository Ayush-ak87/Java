package LinkedList_Questions;

import LinkedList_Questions.LinkedList.*;

public class ZigZag_LL {
    public void zigzag(Node head) {
        //find mid
        Node slow = head;
        Node fast = head.next;

        while (fast !=null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        // reverse 2nd half
        Node curr =mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternate merge-> zigzag merge
        while (left!=null && right!=null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            
            left =nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();

        ZigZag_LL zz = new ZigZag_LL();
        zz.zigzag(ll.head);
        ll.print();
    }
}
