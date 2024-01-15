package Queues.CircularQueue;

public class Runner {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.printQueue();
        cq.dequeue();
        cq.printQueue();
    }
}
