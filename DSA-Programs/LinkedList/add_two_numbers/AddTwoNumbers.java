package LinkedList.add_two_numbers;

import LinkedList.ll_implementation.Node;

/**
 * 
 * 1->2>3
 * 
 * 4-5-6
 * 
 * 321
 * 654
 * ---
 * 975
 */
public class AddTwoNumbers {
    public static Node add(Node head1, Node head2){
        Node dummy = new Node(0, null);
        Node temp = dummy;
        int carry = 0;

        while (head1!=null || head2!=null || carry ==1) {
            int sum = 0;
            if (head1!=null) {
                sum+=head1.data;
                head1=head1.next;
            }   

            if (head2!=null) {
                sum+=head2.data;
                head2 = head2.next;
            }

            sum+=carry;
            carry = sum/10;

            Node newNode = new Node(sum%10, null);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}
