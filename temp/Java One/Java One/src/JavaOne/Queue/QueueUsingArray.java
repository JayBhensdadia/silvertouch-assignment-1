package JavaOne.Queue;

public class QueueUsingArray {
    
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(){
        data = new int[5];
        front = -1;
        rear = -1;
        size = 0;
    }
    public QueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    

    // size
    public int size(){
        return size;
    }

    //isEmpty
    public boolean isEmpty(){
        return size==0;
    }

    //front
    public int front() throws QueueEmptyException{
        if(front==-1){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    //enqueue
    public void enqueue(int element) throws QueueFullException{

        if(size==data.length){
            throw new QueueFullException();
        }

        if(size==0){
            front++;
        }
        rear++;
        data[rear] = element;
        size++;
    }

    //dequeue
    public int dequeue() throws QueueEmptyException{
        if(size==0){
            throw new QueueEmptyException();
        }
        int temp =  data[front];
        front++;
        size--;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return temp;
    }
    

}
