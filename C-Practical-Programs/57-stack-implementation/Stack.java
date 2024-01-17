

import java.util.ArrayList;

public class Stack {
    public int top;
    private ArrayList<Character> list;
    

    public Stack(){
        top = 0;
        list = new ArrayList<>();
    }


    
    public char get(){
        return list.get(list.size()-1);
    }


    
    public void push(char element){
        list.add(element);
        top++;
    }

    
    public void pop(){
        if(this.getLength()==0){
            System.out.println("stack underflow");
            return;
        }
        list.remove(top-1);
        top--;
    }

    
    public int getLength(){
        return list.size();
    }

    

    public static void main(String[] args) {
        Stack stack = new Stack();

        
        stack.push('A');
        stack.push('B');
        stack.push('C');

        
        System.out.println("Stack after pushing elements top: " + stack.get());

        
        stack.pop();

        
        System.out.println("Stack after popping an element top: " + stack.get());

        
        char topElement = stack.get();
        System.out.println("Top element of the stack: " + topElement);

        
        int stackLength = stack.getLength();
        System.out.println("Length of the stack: " + stackLength);
    }

}
