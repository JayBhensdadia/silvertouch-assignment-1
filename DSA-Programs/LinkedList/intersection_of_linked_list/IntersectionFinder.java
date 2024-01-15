package LinkedList.intersection_of_linked_list;

import LinkedList.ll_implementation.Node;

public class IntersectionFinder {
    public static Node findIntersection(Node head1, Node head2){

        Node i = head1;
        Node j = head2;

        while (i!=null) {
            while (j!=null) {
                if(i==j){ return i;}
                j=j.next;
            }
            i=i.next;
        }

        return null;

    } 
}
