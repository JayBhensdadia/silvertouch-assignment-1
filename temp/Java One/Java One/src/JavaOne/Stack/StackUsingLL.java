package JavaOne.Stack;

import JavaOne.LinkedList.Node;

/**
 * here imp thing to note is 
 * 
 * we are adding and deleting at the begining of the LL 
 * not at the end of the LL (because if it is done at the
 * end of the LL then pop operation turns out to be of O(n) )
 * 
 * but in case of begining addition and deletion it is of
 * o(1)
 * 
 * so it would look like 
 * 
 * head=null
 * 
 * push(10) : 10 -> null
 * push(11) : 11 -> 10 -> null (not!!!   10 -> 11 -> null)
 * 
 */

public class StackUsingLL<T> {
    private Node<T> head;
    private int size;

    //constructor
    public StackUsingLL(){
        head = null;
        size = 0;
    }

    //size - O(1)
    public int size(){
        return size;
    }

    //isEmpty - O(1)
    public boolean isEmpty(){
        return size==0;
    }

    //push - O(1)
    public void push(T element){
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;

    }
    //top - O(1)
    public T top() throws StackEmptyExcepiton{
        if(head==null){
            throw new StackEmptyExcepiton();
        }
        return head.data;
    }

    //pop - O(1)
    public T pop() throws StackEmptyExcepiton{
        if(head==null){
            throw new StackEmptyExcepiton();
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

}
