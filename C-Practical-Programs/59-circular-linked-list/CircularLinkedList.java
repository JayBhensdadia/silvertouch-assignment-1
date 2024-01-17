


public class CircularLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int length;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; 
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; 
        }
        length++;
    }

    
    public void delete() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        Node temp = head;
        Node prev = null;

        while (temp.next != head) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = head;
        tail = prev; 
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }
    }

    
    public void printCircularLinkedList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList circularList = new CircularLinkedList();

        circularList.insert(1);
        circularList.insert(2);
        circularList.insert(3);

        System.out.println("Circular Linked List:");
        circularList.printCircularLinkedList();

        circularList.delete();
        System.out.println("After deleting from the end:");
        circularList.printCircularLinkedList();
    }
}

