package JavaOne.LinkedList;
import java.util.Scanner;
public class LL {
    
    //length of linked list
    public int lengthOfLL(Node<Integer> head){
        Node<Integer> i = head;

        int size = 0;

        while (i!=null) {
            size++;
            i = i.next;
        }
        return size;
    }

    //printing linked list
    public void printLL(Node<Integer> head){
        Node<Integer> i = head;
        
        while(i!=null){
            System.out.print(i.data+" -> ");
            i = i.next;
        }
        System.out.print("null");
        System.out.println();

    }

    //inserting node at specified position in linked list
    public  Node<Integer> insertInLL(Node<Integer> head,int data, int pos){

        Node<Integer> newNode = new Node<Integer>(data);

        if(pos == 0){
            Node<Integer> newHead;
            newNode.next = head;
            newHead = newNode;
            return newHead;

        }else{

            Node<Integer> temp = head;
            int j=0;
            while(j<pos-1){
                j++;
                //if the pos is greater than size of LL then do nothing
                if(temp.next == null){
                    return head;
                }
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;


        }
        return head;
        
    }

    //deleting node at specific position
    public  Node<Integer> deleteInLL(Node<Integer> head,int pos){
        if(pos==0){
            head = head.next;
            return head;
        }else{
            Node<Integer> temp = head;
            int j = 0;

            while(j<pos-1){

                //if position is greater than size then do nothing
                if(temp.next==null){
                    return head;
                }

                j++;
                temp = temp.next;
            }

            if(temp.next!=null){

                temp.next = temp.next.next;

            }

            return head;

        }
    }


    //take input form user to create linked list
    public  Node<Integer> takeInputOpt(){
   
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null,tail = null;
        while(data!=-1){


            Node<Integer> currNode = new Node<Integer>(data);
            if(head==null){
                head = currNode;
                tail = currNode;
            }else{
                
                tail.next = currNode;
                tail = tail.next;
                
            }

            data = sc.nextInt();

        }
        sc.close();
        return head;

    }

    //taking input from user to create linked list

    public  Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        while(data!=-1){


            Node<Integer> currNode = new Node<Integer>(data);
            if(head==null){
                head = currNode;
            }else{
                Node<Integer> tail = head;
                while(tail.next!=null){
                    tail = tail.next;
                }
                tail.next = currNode;
                
            }

            data = sc.nextInt();

        }
        return head;
    }



}
