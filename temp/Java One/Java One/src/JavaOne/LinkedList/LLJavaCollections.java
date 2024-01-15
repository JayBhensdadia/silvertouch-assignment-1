package JavaOne.LinkedList;

import java.util.LinkedList;
public class LLJavaCollections {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        System.out.println(ll);
        ll.add(1, 100);
        System.out.println(ll);
        ll.addFirst(11);
        System.out.println(ll);
        System.out.println("size of LL = "+ll.size());

        ll.set(1, 66);

        for (Integer integer : ll) {
            System.out.print(integer+" -> ");
        }
        System.out.println();

        ll.remove();
        System.out.println(ll);
    }
    
}
