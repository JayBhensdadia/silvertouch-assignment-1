package LinkedList.duplicate_remover;

import java.util.ArrayList;

import LinkedList.ll_implementation.LinkedList;
import LinkedList.ll_implementation.Node;

public class DuplicateRemover {

    

    public static Node removeDuplicates(Node head){
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while (temp!=null) {
            if(!arr.contains(temp.data)){arr.add(temp.data);}
            temp = temp.next;
        }

        Node prev = null;
        Node newHead = null;
        for (int i = 0; i < arr.size(); i++) {
            
            Node newNode = new Node(arr.get(i), null);
            if(i==0){
                newHead = newNode;
                prev = newNode;
            }else{
                prev.next = newNode;
                prev = newNode;
            }

        }
        System.out.println(arr);
        return newHead;
    }
}
