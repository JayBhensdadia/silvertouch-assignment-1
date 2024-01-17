package Graph.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Graph.create_and_basic_ops.Graph;

public class BFS {
    public static <T> void printList(List<T> list){
        for (T item : list) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

    public static <T> void bfs(T vertex, Graph<T> graph){

        HashMap<T, List<T> > map = graph.getMap();

        

        Queue<T> queue = new LinkedList<>();
        List<T> visited = new ArrayList<>();

        queue.add(vertex);

        while (!queue.isEmpty()) {
            
            //pop
            T current = queue.poll();
            visited.add(current);


            for (T v : map.get(current)) {
                if (!visited.contains(v) && !queue.contains(v)) {
                    queue.add(v);
                }
            }
        }

        printList(visited);

    }
}
