package JavaOne.PriorityQueue;

public class PQUse {
    public static void main(String[] args) {
        PriorityQueueMax<Integer> pq = new PriorityQueueMax<>();
        pq.insert(10, 10);
        pq.insert(5, 5);
        pq.insert(9, 9);
        pq.insert(1, 1);
        pq.insert(11, 11);
        pq.insert(8, 8);
        pq.insert(12, 12);
        //pq.insert(13, 13);
        
        System.out.println(pq.size());



        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }
        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }

        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }
        pq.removeMax();
        System.out.println();

        for(int i = 0; i < pq.size(); i++){
            System.out.print(pq.heap.get(i).value+" ");
        }
       
        
    }
}
