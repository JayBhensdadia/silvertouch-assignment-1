package LinkedList.intersection_of_linked_list;

import LinkedList.ll_implementation.Node;

public class Runner {
    public static void main(String[] args) {
        Node head1 = new Node(10, null);
        Node head2 = new Node(3, null);

        Node newNode = new Node(6, null);
        head2.next = newNode;

        newNode = new Node(9, null);
        head2.next.next = newNode;

        newNode = new Node(15, null);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30, null);
        head1.next.next = newNode;

        head1.next.next.next = null;

        Node intersectionPoint = IntersectionFinder.findIntersection(head1, head2);

        if (intersectionPoint == null) {
            System.out.print(" No Intersection Point \n");
        } else {
            System.out.print("Intersection Point: "+ intersectionPoint.data);
        }
    }
}
