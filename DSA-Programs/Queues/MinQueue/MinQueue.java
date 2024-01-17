package Queues.MinQueue;

import java.util.Stack;

public class MinQueue {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinQueue() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        mainStack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int poppedElement = mainStack.pop();

        if (poppedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (mainStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        MinQueue minQueue = new MinQueue();

        minQueue.push(3);
        minQueue.push(5);
        minQueue.push(2);
        minQueue.push(1);

        System.out.println("Top element: " + minQueue.top());
        System.out.println("Minimum element: " + minQueue.getMin());

        minQueue.pop();

        System.out.println("Top element after pop: " + minQueue.top());
        System.out.println("Minimum element after pop: " + minQueue.getMin());
    }
}
