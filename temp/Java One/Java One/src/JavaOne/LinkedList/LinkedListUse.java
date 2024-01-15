package JavaOne.LinkedList;

public class LinkedListUse {

    //creating temporary Linked List
    public static Node<Integer> createLL() {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(20);
        Node<Integer> n3 = new Node<Integer>(30);
        Node<Integer> n4 = new Node<Integer>(40);
        Node<Integer> n5 = new Node<Integer>(50);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;

    }

    //print recursively
    public static void printRecursive(Node<Integer> head) {
        if (head == null) {
            System.out.print("null");
            return;
        }
        System.out.print(head.data + " -> ");
        printRecursive(head.next);
    }

    //print reverse LL recursively
    public static void printRecursiveReverse(Node<Integer> head) {

        if (head == null) {
            System.out.print("null");
            return;
        }

        printRecursiveReverse(head.next);
        System.out.print(" <- " + head.data);

    }

    //insert Recursively
    public static Node<Integer> insertRecursive(Node<Integer> head, int data, int pos) {


        // if head becomes null then not going any further
        // just returning head from here
        if (head == null) {
            return head;
        }

        if (pos == 0) {
            Node<Integer> newNode = new Node<>(data);
            newNode.next = head;
            return newNode;

        }

       

        // getting temporary head
        Node<Integer> tempHead = insertRecursive(head.next, data, pos - 1);
        // attaching to current head
        head.next = tempHead;
        // returning current head
        return head;
    }

    //delete Recursively
    public static Node<Integer> deleteRecursive(Node<Integer> head, int pos){

        //if head becomes null , return from there
        if(head==null){
            return head;
        }

        //base case
        if(pos == 0){
            head = head.next;
            return head;
        }

        
        //getting temporary head
        Node<Integer> tempHead = deleteRecursive(head.next, pos - 1);
        //attaching temp head to current head
        head.next = tempHead;
        //returning current head
        return head;


    }
    
    //reverse recursively
    public static Node<Integer> reverseRecurive(Node<Integer> head){

        //base case
        if(head.next==null){
            return head;
        }

        //getting temp head of reversed linked list
        Node<Integer> tempHead = reverseRecurive(head.next);

        //traveling to the end of the temp linked list 
        Node<Integer> i = tempHead;
        while(i.next!=null){
            i=i.next;
        }
        //attaching head (old) node to temp linked list at last
        i.next = head;
        head.next = null;
        //returning tempHead ; as it is our new head
        return tempHead;
    }


    //reverse recursively better helper
    public static DoubleNode reverseBetter1(Node<Integer> head){
        DoubleNode ans;
        if(head==null || head.next==null){
            ans = new DoubleNode(head, head);
            return ans;
        }

        DoubleNode temp = reverseBetter1(head.next);
        temp.tail.next = head;
        head.next = null;
        ans = new DoubleNode(temp.head, head);
        return ans;

    }

    // reverse recursive better
    public static Node<Integer> reverseBetter(Node<Integer> head){
        DoubleNode ans = reverseBetter1(head);
        return ans.head;
    }

    //reverse recursive better 2
    public static Node<Integer> reverseBetter3(Node<Integer> head){
        if(head==null || head.next==null){
            return head;
        }

        Node<Integer> tempHead = reverseBetter3(head.next);
        /* if we understand closely reverseBetter3 gives us the
         * reverse linied list from index 1 now we just need to 
         * append old head node at the end of the linked list returned
         * by reverseBetter3 for that we dont need to travrse to end 
         * by loop or maintain variable called tail, what we
         * can do instead is use old head to access tail of new LL
         * because tail of new LL is just next to old Head
         */

        // head.next = tail
        // setting tail.next = head
        head.next.next = head;
        //head is now overall last node of new LL
        //so setting head.next to null
        head.next = null;
        //returning new head
        return tempHead;
    }
   

    //reverse iterative
    public static Node<Integer> reverseIterative(Node<Integer> head){

        if(head==null || head.next==null){
            return head;
        }

        Node<Integer> curr = head;
        Node<Integer> previous = null;

        while(curr!=null){

            //saving the link to next node of curr
            Node<Integer> curr_next = curr.next;
            //breaking old link and creating new
            curr.next = previous;
            //updating previous 
            previous = curr;
            //going to next node in old LL
            curr = curr_next;
        }
        return previous;

    }

   

    //middle of the linked list
    public static Node<Integer> midOfLL(Node<Integer> head){
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //merging two sorted linked list
    public static Node<Integer> mergeTwoSortedLL(Node<Integer> head1, Node<Integer> head2){

        if(head1==null){
            return head2;
        }else if(head2==null){
            return head1;
        }

        //pointer to LL1
        Node<Integer> t1 = head1;
        //pointer to LL2
        Node<Integer> t2 = head2;
        //pointers to merged LL
        Node<Integer> head;
        Node<Integer> tail;

        
        //getting the head of the merged LL
        if(t1.data < t2.data){
            head = t1;
            tail = t1;
            t1 = t1.next;
        }else{
            head = t2;
            tail = t2;
            t2 = t2.next;
        }

        while(t1!=null && t2!=null){

            if(t1.data < t2.data){
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }else{
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }

        }

        //if t2 is null then just appending remaining t1
        if(t1!=null){
            tail.next = t1;
        }

        //if t1 is null then just appending remaining t2
        if(t2!=null){
            tail.next = t2;
        }

        return head;

    }


    //merge sort on LL
    public static Node<Integer> mergeSortLL(Node<Integer> head){

        //base case
        if(head==null || head.next == null){
            return head;
        }

        //finding mid point of LL
        Node<Integer> mid = midOfLL(head);


        // so LL1 will start at
        Node<Integer> part1Head = head;
        // so LL2 will start at
        Node<Integer> part2Head = mid.next;
        // we have to break LL to get LL1 and LL2 
        // breaking will happen at mid point
        mid.next = null;

        Node<Integer> tempHead1 = mergeSortLL(part1Head);
        Node<Integer> tempHead2 = mergeSortLL(part2Head);
        return mergeTwoSortedLL(tempHead1, tempHead2);

    }

    public static void main(String[] args) {



        LL pl = new LL();
        Node<Integer> head = pl.takeInput();
        pl.printLL(reverseRecurive(head));
        
        // printRecursive(head);
        // System.out.println();
        // head = reverseBetter3(head);
        // printRecursive(head);
        // System.out.println();
        // head = insertRecursive(head, 29, 0);
        // printRecursive(head);

        // output:
        // 10 -> 20 -> 30 -> 40 -> null
        // null <- 40 <- 30 <- 20 <- 10

    }
}
