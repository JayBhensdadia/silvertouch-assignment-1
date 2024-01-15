package Queues.generate_binary_numbers;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    /*
     * Create an empty queue of strings
     * Enqueue the first binary number “1” to the queue.
     * Now run a loop for generating and printing n binary numbers.
     * Dequeue and Print the front of queue.
     * Append “0” at the end of front item and enqueue it.
     * Append “1” at the end of front item and enqueue it.
     */

    public static void generateBins(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String s1 = q.remove();
            System.out.println(s1);

            String s2 = s1;
            q.add(s1 + "0");

            q.add(s2 + "1");

        }
    }

    public static void main(String[] args) {
        int n = 10;
        generateBins(n);
    }

}
