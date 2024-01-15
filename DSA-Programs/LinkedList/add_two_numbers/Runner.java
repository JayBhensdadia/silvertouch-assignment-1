package LinkedList.add_two_numbers;

import LinkedList.ll_implementation.LinkedList;
import LinkedList.ll_implementation.Node;

/**
 * 
 * 321
 * 854
 * ---
 * 1175
 * 
 */
public class Runner {
    public static void main(String[] args) {
        Node head1 = new Node(1, null);
        Node head2 = new Node(4, null);

        LinkedList l1 = new LinkedList(head1);
        LinkedList l2 = new LinkedList(head2);

        l1.insert(2);
        l1.insert(3);

        l2.insert(5);
        l2.insert(8);

        Node ansHead = AddTwoNumbers.add(head1, head2);
        LinkedList ans = new LinkedList(ansHead);
        ans.printLinkedList();

    }
}
