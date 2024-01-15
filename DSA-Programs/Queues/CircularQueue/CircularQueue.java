package Queues.CircularQueue;

import java.util.ArrayList;

public class CircularQueue {
    public int front;
    public int rear;
    public int length;
    private ArrayList<Integer> list;

    public CircularQueue(int size){
        this.length = size;
        this.front = this.rear = -1;
        list = new ArrayList<>(size);
    }

    //enqueue
    public void enqueue(int element){
        if(front==-1 && rear==-1){
            list.add(element);
            front = 0;
            rear = 0;
        }else if((rear+1)%this.length == front){
            System.out.println("Queue overflow");
        }else{
            rear = (rear+1)%this.length;
            list.add(rear, element);
        }
    }


    //dequeue
    public int dequeue(){
        int ans = -1;
        if(front==-1 && rear==-1){
            System.out.println("Queue underflow!");
            
        }else if(front==rear){
            ans = list.get(front);
            list.remove(front);
            front = -1;
            rear = -1;
            

        }else{
            ans = list.get(front);
            list.remove(front);
            front = (front+1)%this.length;
        }

        return ans;
    }


    //print queue

    public void printQueue(){
        System.out.println(list);
        return;
    }


}
