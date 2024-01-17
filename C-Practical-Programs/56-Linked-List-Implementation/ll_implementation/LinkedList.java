



class Node {
    public int data;
    public Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

public class LinkedList {

    public Node head;
    public Node tail;
    public int length;

    public LinkedList(Node head) {
        this.head = head;
        this.tail = head;
        this.length = 1;
    }


    public void insert(int data) {
        Node temp = tail;
        Node newNode = new Node(data, null);
        temp.next = newNode;
        tail = newNode;
        length++;
    }

    public void insert(int data, int index) {



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
    

    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }


    public int getMiddleElement(){
        Node slow = head;
        Node fast = head;

        while (fast!=null &&fast.next!=null ) {
            fast= fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }


    
    public static Node reverseLL(Node head){

        if(head==null || head.next==null){ return head;}
        
        Node temp = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }



    
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

    public static void main(String[] args) {
        
        Node headNode = new Node(1, null);
        LinkedList ll = new LinkedList(headNode);
        
        ll.insert(2);
        
        ll.insert(3,2);
        
        ll.insert(4);
        ll.printLinkedList();
        
        

        // ll.head.next.next.next.next = ll.head.next;

        // System.out.println(LinkedList.detectCycle(headNode));
        
        // System.out.println(ll.length);
        // ll.insert(5, 1);
        // ll.printLinkedList();
        // ll.delete(3);
        // ll.printLinkedList();

        ll.head = LinkedList.reverseLL(headNode);
        ll.printLinkedList();
        
        
    }

    

}
