package Graph.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import Graph.create_and_basic_ops.Graph;

public class DFS {

    public static <T> void printList(List<T> list){
        for (T item : list) {
            System.out.print(item+" ");
        }
        System.out.println();
    }
    public static <T> void dfs(T vertex, Graph<T> graph){
        HashMap<T, List<T> > map = graph.getMap();

        

        Stack<T> stack = new Stack<>();
        List<T> visited = new ArrayList<>();

        stack.push(vertex);
        
        while (!stack.isEmpty()) {
            
            //pop
            T current = stack.pop();
            visited.add(current);


            //push non visited adjacent vertices
            for (T v : map.get(current)) {
                if (!visited.contains(v) && !stack.contains(v)) {
                    stack.push(v);
                }
            }
            
        }

        printList(visited);
        
    }
}
