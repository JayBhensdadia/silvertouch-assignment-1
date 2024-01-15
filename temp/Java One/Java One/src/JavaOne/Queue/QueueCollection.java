package JavaOne.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {
    public static void main(String[] args) {
        
        Queue<Integer> queue = new LinkedList<>();

        
        queue.add(10);
        queue.add(11);
        queue.add(12);
        queue.add(13);
        queue.add(14);

        System.out.println(queue);

        queue.remove();
        System.out.println(queue);
        System.out.println(queue.peek());

        

    }
}
