package JavaOne.Queue;

public class QueueUse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        QueueUsingStacks q = new QueueUsingStacks<>();
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(111);
        q.enqueue(110);
        q.enqueue(120);
        System.out.println("size = "+q.size());
        q.dequeue();
        q.dequeue();
        System.out.println("front = "+q.front());
        q.enqueue(3);
        q.enqueue(31);
        q.enqueue(122);
        q.enqueue(123);

        System.out.println("front = "+q.front());
        System.out.println("size = "+q.size());

        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }
    }
}
