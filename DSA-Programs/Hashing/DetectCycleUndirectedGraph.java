package Hashing;



import java.util.HashMap;
import java.util.List;

import Graph.create_and_basic_ops.Graph;

public class DetectCycleUndirectedGraph<T> {

    private Graph<T> graph;

    public DetectCycleUndirectedGraph(Graph<T> graph) {
        this.graph = graph;
    }

    public boolean hasCycle() {
        HashMap<T, Boolean> visited = new HashMap<>();

        for (T vertex : graph.getMap().keySet()) {
            visited.put(vertex, false);
        }

        for (T vertex : graph.getMap().keySet()) {
            if (!visited.get(vertex) && isCyclicUtil(vertex, visited, null)) {
                return true; 
            }
        }

        return false; 
    }

    private boolean isCyclicUtil(T vertex, HashMap<T, Boolean> visited, T parent) {
        visited.put(vertex, true);

        List<T> neighbors = graph.getMap().get(vertex);

        for (T neighbor : neighbors) {
            if (!visited.get(neighbor)) {
                if (isCyclicUtil(neighbor, visited, vertex)) {
                    return true; 
                }
            } else if (!neighbor.equals(parent)) {
                return true; 
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 1, true);
       

        DetectCycleUndirectedGraph<Integer> cycleDetector = new DetectCycleUndirectedGraph<>(graph);
        boolean hasCycle = cycleDetector.hasCycle();

        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}

