package JavaOne.Stack;

public class StackUsingArray {
    
    private int[] data;
    private int topIndex;

    //constructors
    StackUsingArray(){
        data = new int[10];
        topIndex = -1;
    }
    StackUsingArray(int n){
        data = new int[n];
        topIndex = -1;
    }

    //isEmpty - O(1)
    public boolean isEmpty(){
        return topIndex==-1;
    }

    //size - O(1)
    public int size(){
        return topIndex+1;
    }

    //push - O(1)
    public void push(int n) throws StackFullException{
        if(topIndex==data.length-1){
            throw new StackFullException();
        }
        data[++topIndex] = n;
    }

    //top - O(1)
    public int top() throws StackEmptyExcepiton{
        if(topIndex==-1){
            throw new StackEmptyExcepiton();
        }
        return data[topIndex];
    }

    //pot - O(1)
    public int pop() throws StackEmptyExcepiton{
        if(topIndex==-1){
            throw new StackEmptyExcepiton();
        }
        int popped = data[topIndex];
        topIndex--;
        return popped;
    }

}
