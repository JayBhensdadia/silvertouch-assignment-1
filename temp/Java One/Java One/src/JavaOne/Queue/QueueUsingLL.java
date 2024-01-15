package JavaOne.Queue;

import JavaOne.LinkedList.Node;

public class QueueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;

    QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    //size
    public int size(){
        return size;
    }

    //isEmpty()
    public boolean isEmpty(){
        return size==0;
    }

    //enqueue
    public void enqueue(T element){
        Node<T> newNode = new Node<>(element);
        if(size==0){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        
        size++;
    }

    //dequeue
    public T dequeue() throws QueueEmptyException{
        if(size==0){
            throw new QueueEmptyException();
        }
        T temp;
        if(size==1){
            temp = front.data;
            front=null;
            rear = null;
            
        }else{
            temp = front.data;
            front=front.next;
        }
        size--;
        return temp;
    }

    //front()
    public T front() throws QueueEmptyException{
        if(front==null){
            throw new QueueEmptyException();
        }
        return front.data;
    }

}
