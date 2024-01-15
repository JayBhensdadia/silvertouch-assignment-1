package LinkedList.ll_implementation;



public class Runner {
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
