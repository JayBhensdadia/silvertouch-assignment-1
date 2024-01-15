package JavaOne.Queue;

public class CircularQueueUsingArray {
    private int[] data;
    private int front;
    private int rear;
    private int size;

    public CircularQueueUsingArray(){
        data = new int[3];
        front = -1;
        rear = -1;
        size = 0;
    }
    public CircularQueueUsingArray(int capacity){
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void doubleCapacity(){
        int[] temp = data;
        data = new int[temp.length*2];
        int index = 0;
        for(int i = front; i < temp.length; i++){
            data[index++] = temp[i];
        }
        for(int j = 0; j < front; j++){
            data[index++] = temp[j];
        }
        front=0;
        rear = temp.length - 1;

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
    public void enqueue(int element){

        if(size==data.length){
            doubleCapacity();
        }

        if(size==0){
            front++;
        }
        // rear++;
        // if(rear==data.length){
        //     rear = 0;
        // }

        

        //writing above in short
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
    }

    //dequeue
    public int dequeue() throws QueueEmptyException{
        if(size==0){
            throw new QueueEmptyException();
        }
        int temp =  data[front];
        //front++;
        // if(front==data.length){
        //     front = 0;
        // }

        //writing above in short
        front = (front + 1) % data.length;
        size--;
        if(size==0){
            front=-1;
            rear=-1;
        }
        return temp;
    }
    
}
