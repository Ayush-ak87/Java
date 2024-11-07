package Queues_Questions;

import java.util.*;

public class Queue_Using_JCF {

    public static void main(String[] args) {
        //Queue q = new Queue();
        Queue<Integer> q = new LinkedList<>(); // Also Using ArrayDeque
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.err.println(q.peek());
            q.remove();
        }
    }
}
