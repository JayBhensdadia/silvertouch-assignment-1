package LinkedList.ll_implementation;

import LinkedList.*;

public class LinkedList {

    public Node head;
    public Node tail;
    public int length;

    public LinkedList(Node head) {
        this.head = head;
        this.tail = head;
        this.length = 1;
    }

    //insertion
    public void insert(int data) {
        Node temp = tail;
        Node newNode = new Node(data, null);
        temp.next = newNode;
        tail = newNode;
        length++;
    }

    public void insert(int data, int index) {

        /*
         * insert(6,2)
         * ----------
         * 1 2 3 4 5
         * ------------
         * 0 1 2 3 4
         * 
         * 
         * -------------
         * 1 2 6 3 4 5
         * 
         */

        int i = 0;
        Node temp = head;

        if (index > length) {
            System.out.println("Invalid index");
            return;
        } else if (index == length) {
            this.insert(data);
        }else if(index == 0){

            Node newNode = new Node(data, null);
            newNode.next = head;
            head = newNode;

        } else {

            while (i < index - 1) {
                temp = temp.next;
                i++;
            }

            Node newNode = new Node(data, null);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }

    }


    //deletion
    public void delete() {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        length--;
    }

    
    public void delete(int index){
        
        int i = 0;
        Node temp = head;

        if(index >= length){
            System.out.println("Invalid index");
            return;
        }else if (index == 0) {
            head = head.next;
        }else if(index == length-1){
            this.delete();
        }else{


            while (i < index - 1) {
                temp = temp.next;
                i++;
            }

            temp.next = temp.next.next;
            length--;

        }
    }
    

    //traversal
    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }


    //get the middle element
    public int getMiddleElement(){
        Node slow = head;
        Node fast = head;

        while (fast!=null &&fast.next!=null ) {
            fast= fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }


    //reverse linked list
    public static Node reverseLL(Node head){

        if(head==null || head.next==null){ return head;}
        
        Node temp = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }



    //detect cycle
    public static boolean detectCycle(Node head){
        Node fast = head;
        Node slow = head;


        while (slow!=null && fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){ return true;}
        }

        return false;
    }


    

}
