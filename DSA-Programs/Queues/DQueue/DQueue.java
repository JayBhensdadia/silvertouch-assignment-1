package Queues.DQueue;

import java.util.LinkedList;

public class DQueue<T> {
    private LinkedList<T> deque = new LinkedList<>();

    
    public void addFirst(T element) {
        deque.addFirst(element);
    }

    
    public void addLast(T element) {
        deque.addLast(element);
    }

    
    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        return deque.removeFirst();
    }

    
    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        return deque.removeLast();
    }

    
    public T peekFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        return deque.peekFirst();
    }

    
    public T peekLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return null;
        }
        return deque.peekLast();
    }

  
    public boolean isEmpty() {
        return deque.isEmpty();
    }

  
    public int size() {
        return deque.size();
    }

    public static void main(String[] args) {
        DQueue<Integer> dQueue = new DQueue<>();

        dQueue.addFirst(1);
        dQueue.addLast(2);
        dQueue.addFirst(3);
        dQueue.addLast(4);

        System.out.println("Deque: " + dQueue.peekFirst() + " ... " + dQueue.peekLast());
        System.out.println("Deque size: " + dQueue.size());

        dQueue.removeFirst();
        dQueue.removeLast();

        System.out.println("Deque after removal: " + dQueue.peekFirst() + " ... " + dQueue.peekLast());
    }
}
