package JavaOne.PriorityQueue;

import java.util.ArrayList;

public class PriorityQueueMin<T> {
    public ArrayList<Element<T>> heap;

    //constructor
    public PriorityQueueMin(){
        heap = new ArrayList<>();
    }

    //insert
    public void insert(T value, int priority){
        //creating element to be added
        heap.add(new Element<T>(value, priority));

        //index where new element is added
        int index = heap.size()-1;

        //maintaining heap order of heap

        //check it untill we find smaller parent or 
        //newly inserted element reaches top
        while(index!=0 && heap.get(index).priority<heap.get((index-1)/2).priority){

            //if the element is less than its parent
            //swap it with parent
            Element<T> temp = heap.get(index);
            heap.set(index, heap.get((index-1)/2));
            heap.set((index-1)/2,temp);

            //now our elment will be at index of parent
            index = (index-1)/2;
        }

    }
    
    //getMin
    public T getMin(){
        if(!isEmpty()){
            return heap.get(0).value;
        }else{
            return null;
        }
        
    }

    //removeMin
    public T removeMin(){

        if(isEmpty()){
            System.out.println("pq is empty");
            return null;
        }

        //swapping min element with the last element
        Element<T> temp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.set(heap.size()-1, temp);
        
        //deleting last element
        heap.remove(heap.size()-1);

        //initial parentIndex , leftChildIndex and rightChildIndex
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;


        //we need to swap parentIndex with the min of its two child
        //until we reach the end or
        //the parent is smaller than children

        //so when leftChildIndex becomes equal to heap.size we can
        //say that CBT is over now; so stop
        while(leftChildIndex < heap.size()){

            //minIndex
            int minIndex = parentIndex;

            //if leftChildIndex < minIndex
            if(heap.get(leftChildIndex).priority < heap.get(minIndex).priority){
                minIndex = leftChildIndex;
            }

            //if rightChild exist and rightChildIndex < minIndex
            if(rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority){
                minIndex = rightChildIndex;
            }

            //if minIndex is still equal to parentIndex
            //that means we reached there parent is smaller than both its children
            //so no need to go further
            if(minIndex==parentIndex){
                break;
            }

            //now swap the parentIndex with the minIndex
            Element<T> t = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, t);

            //increment the indices
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;


        }

        return temp.value;

    }

    //size
    public int size(){
        return heap.size();
    }

    //isEmpty
    public boolean isEmpty(){
        return heap.size()==0;
    }
}
