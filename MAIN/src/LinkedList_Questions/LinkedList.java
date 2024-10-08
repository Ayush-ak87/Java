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
    public static int size;
    //Methods
    //Add_First In Java
    public void addFirst(int data) {
        //Step 1 = Create New Node
        Node  newNode = new Node(data);
        size++;
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
        size++;
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
        size++;
        Node temp = head;
        int i = 0;

        while (i< idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next =newNode;
    }

    public int removeFirst() {
        if (size==0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size==0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val = head.data;
            head = tail = null;
            size=0;
            return val;
        }
        //prev : size-2
        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size --;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp!=null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    // Recursive Search
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx ==-1) {
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key) {
        return helper(head,key);
    }

    //Reverse a LinkedList
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp!=null) {
            temp = temp.next;
            sz++;
        }
        if (n==sz) {
            head = head.next;
            return;
        }

        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    
    // Function to check LinkedList is Palindrome or not
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //slow is my midNode
    }
    public boolean checkPalindrome() {
        if (head==null || head.next==null) {
            return true;
        }
        // Step 1- Find MidNode
        Node midNode = findMid(head);
        // Step 2- Reverse 2nd Half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        //Step 3 - Check 1st half(left) = 2nd Half(right)
        while (right!=null) {
            if (left.data!=right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {  // Floyd's Cycle Finding Algorithm
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }

        //finding meeting point
        slow = head;
        Node prev = null;
        while (slow!=fast) {
            prev = fast;
            slow = slow.next;
            fast= fast.next;
        }
        //remove cycle
        prev.next = null;
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
        System.out.println(LinkedList.size);
        ll.removeFirst();
        ll.print();
        System.out.println(LinkedList.size);
        ll.removeLast();
        ll.print();
        System.out.println(LinkedList.size);
        System.out.println(ll.itrSearch(3));
        System.out.println(ll.recSearch(3));
        ll.reverse();
        ll.print();
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.deleteNthFromEnd(2);
        ll.print();
        ll.addLast(3);
        ll.print();
        System.out.println(ll.checkPalindrome());
        ll.print();
        System.out.println(isCycle());
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        //1->2->3->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }

}
