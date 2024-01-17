package Graph.DetectCycle_in_Directed;

import java.util.HashMap;
import java.util.List;

import Graph.create_and_basic_ops.Graph;

public class DetectCycleDirectedGraph<T> {

    private Graph<T> graph;

    public DetectCycleDirectedGraph(Graph<T> graph) {
        this.graph = graph;
    }

    public boolean hasCycle() {
        
        HashMap<T, Boolean> visited = new HashMap<>();

        
        HashMap<T, Boolean> recursionStack = new HashMap<>();

        
        for (T vertex : graph.getMap().keySet()) {
            visited.put(vertex, false);
            recursionStack.put(vertex, false);
        }

        
        for (T vertex : graph.getMap().keySet()) {
            if (!visited.get(vertex) && isCyclicUtil(vertex, visited, recursionStack)) {
                return true; 
            }
        }

        return false; 
    }

    private boolean isCyclicUtil(T vertex, HashMap<T, Boolean> visited, HashMap<T, Boolean> recursionStack) {
        visited.put(vertex, true);
        recursionStack.put(vertex, true);

        List<T> neighbors = graph.getMap().get(vertex);

        for (T neighbor : neighbors) {
            if (!visited.get(neighbor)) {
                if (isCyclicUtil(neighbor, visited, recursionStack)) {
                    return true; 
                }
            } else if (recursionStack.get(neighbor)) {
                return true; 
            }
        }

        recursionStack.put(vertex, false);
        return false;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2, false);
        graph.addEdge(2, 3, false);
        graph.addEdge(3, 1, false);
        //graph.addEdge(1, 3, false);

        DetectCycleDirectedGraph<Integer> cycleDetector = new DetectCycleDirectedGraph<>(graph);
        boolean hasCycle = cycleDetector.hasCycle();

        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
