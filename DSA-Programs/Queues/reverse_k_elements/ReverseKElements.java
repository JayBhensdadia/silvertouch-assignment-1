package Queues.reverse_k_elements;

import java.util.ArrayList;

import Queues.Queue.Queue;

public class ReverseKElements {

    // [1,2,3,4,5] , 3 ==> [ 3, 4 5,1, 2]
    public static void reverse(Queue q, int k){
        ArrayList<Integer> list = new ArrayList<>();
        int n = q.getLength();
        for (int i = 0; i < n-k; i++) {
            list.add(q.dequeue());
        }

        for (Integer i : list) {
            q.enqueue(i);
        }
    }
}
