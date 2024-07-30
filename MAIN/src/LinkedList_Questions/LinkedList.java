package LinkedList_Questions;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    //Methods
    //Add_First In Java
    public void addFirst(int data) {
        //Step 1 = Create New Node
        Node  newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //Step 2 - newNode next = head
        newNode.next = head;
        //Step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node  newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head==null) {
            System.out.println("LL is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx==0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while (i< idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next =newNode;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();
        ll.add(2, 9);
        ll.print();
    }

}
