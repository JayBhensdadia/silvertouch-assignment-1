package Queues.Queue;

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

    //getLength
    public int getLength(){
        return list.size();
    }


    //enqueue
    public void enqueue(int element){
        list.add(element);
        rear = list.size()-1;
    }

    //dequeue
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

    //print queue
    public void printQueue(){
        System.out.println(list);
    }
}
