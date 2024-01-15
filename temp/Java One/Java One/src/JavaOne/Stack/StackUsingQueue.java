package JavaOne.Stack;
import java.util.*;
public class StackUsingQueue {
    
    //Define the data members
    Queue<Integer> q1;
    Queue<Integer> q2;


    public StackUsingQueue() {
        //Implement the Constructor
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return q1.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return q1.isEmpty();
    }

    public void push(int element) {
        //Implement the push(element) function
        q2.add(element);

        while(q1.size()!=0){
            q2.add(q1.poll());
        }
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    public int pop() {
        //Implement the pop() function
        
       if(q1.size()==0){
            return -1;
       }

       return q1.poll();
        
    }

    public int top() {
        //Implement the top() function
        if(q1.size()==0){
            return -1;
        }
        return q1.peek();
    }

}
