

import java.util.ArrayList;

public class Queue {
    public int front;
    public int rear;
    private ArrayList<Integer> list;

    public Queue(){
        front = 0;
        rear = 0;
        list = new ArrayList<>();
    }

    
    public int getLength(){
        return list.size();
    }


    
    public void enqueue(int element){
        list.add(element);
        rear = list.size()-1;
    }

    
    public int dequeue(){
        if(this.getLength()==0){
            System.out.println("Queue underflow");
            return -1;
        }
        int ans = list.get(0);
        list.remove(0);
        rear = list.size()-1;
        return ans;
    }

    
    public void printQueue(){
        System.out.println(list);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        
        System.out.println("Queue after enqueuing elements: ");
        queue.printQueue();

        
        int dequeuedElement = queue.dequeue();
        System.out.println("Dequeued element: " + dequeuedElement);

        
        System.out.println("Queue after dequeuing an element: ");
        queue.printQueue();

        
        int queueLength = queue.getLength();
        System.out.println("Length of the queue: " + queueLength);
    }
}
