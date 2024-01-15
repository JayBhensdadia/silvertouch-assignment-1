package JavaOne.Queue;

import java.util.Stack;

public class QueueUsingStacks<T> {
    Stack<T> s1;
    Stack<T> s2;

    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    //size
    public int size(){
        return s1.size();
    }

    //isEmpty
    public boolean isEmpty(){
        return s1.isEmpty();
    }

    //enqueue
    public void enqueue(T element){
        s1.push(element);
    }

    //dequeue
    public T dequeue(){
        for(int i = 0; i < s1.size()-1;i++){
            s2.push(s1.pop());
        }
        T temp = s1.pop();
        for (int j = 0; j < s2.size(); j++) {
            s1.push(s2.pop());
        }
        return temp;
    }

    //front
    public T front(){

        for(int i = 0; i < s1.size()-1;i++){
            s2.push(s1.pop());
        }
        T temp = s1.peek();
        for (int j = 0; j < s2.size(); j++) {
            s1.push(s2.pop());
        }
        return temp;

    }

}
