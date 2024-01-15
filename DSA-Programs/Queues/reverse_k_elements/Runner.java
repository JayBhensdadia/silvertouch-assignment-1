package Queues.reverse_k_elements;

import Queues.Queue.Queue;

public class Runner {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.printQueue();
        ReverseKElements.reverse(q, 3);
        q.printQueue();
    }
}
