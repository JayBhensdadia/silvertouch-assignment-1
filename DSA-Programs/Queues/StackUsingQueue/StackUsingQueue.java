package Queues.StackUsingQueue;

import java.util.*;
public class StackUsingQueue {
    
    
    Queue<Integer> q1;
    Queue<Integer> q2;


    public StackUsingQueue() {
        
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }





    public int getSize() { 
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void push(int element) {

        q2.add(element);

        while(q1.size()!=0){
            q2.add(q1.poll());
        }
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    public int pop() {

        
       if(q1.size()==0){
            return -1;
       }

       return q1.poll();
        
    }

    public int top() {

        if(q1.size()==0){
            return -1;
        }
        return q1.peek();
    }

}
