package Stacks.stack;

import java.util.ArrayList;

public class Stack {
    public int top;
    private ArrayList<Character> list;
    

    public Stack(){
        top = 0;
        list = new ArrayList<>();
    }


    //get top element
    public char get(){
        return list.get(list.size()-1);
    }


    //push
    public void push(char element){
        list.add(element);
        top++;
    }

    //pop
    public void pop(){
        if(this.getLength()==0){
            System.out.println("stack underflow");
            return;
        }
        list.remove(top-1);
        top--;
    }

    //getlength
    public int getLength(){
        return list.size();
    }

}
