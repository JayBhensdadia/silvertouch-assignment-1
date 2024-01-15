package LinkedList.duplicate_remover;

import LinkedList.ll_implementation.LinkedList;
import LinkedList.ll_implementation.Node;

public class Runner {
    public static void main(String[] args) {
        Node headNode = new Node(1, null);
        LinkedList ll = new LinkedList(headNode);
        
        ll.insert(2);
        
        ll.insert(3,2);
        
        ll.insert(4);
        ll.insert(4);
        ll.insert(1,0);
        ll.printLinkedList();

        Node newHead = DuplicateRemover.removeDuplicates(headNode);
        LinkedList newLL = new LinkedList(newHead);
        newLL.printLinkedList();
    }
}
