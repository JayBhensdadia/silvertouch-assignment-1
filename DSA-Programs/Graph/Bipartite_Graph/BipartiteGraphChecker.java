package Graph.Bipartite_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Graph.create_and_basic_ops.Graph;

public class BipartiteGraphChecker<T> {

    private Graph<T> graph;

    public BipartiteGraphChecker(Graph<T> graph) {
        this.graph = graph;
    }

    public boolean isBipartite() {
        
        HashMap<T, String> colorMap = new HashMap<>();

        
        for (T vertex : graph.getMap().keySet()) {
            colorMap.put(vertex, "Uncolored");
        }

        
        for (T vertex : graph.getMap().keySet()) {
            if (colorMap.get(vertex).equals("Uncolored") && !isBipartiteUtil(vertex, colorMap, "Color1")) {
                return false; 
            }
        }

        return true; 
    }

    private boolean isBipartiteUtil(T vertex, HashMap<T, String> colorMap, String currentColor) {
        colorMap.put(vertex, currentColor);

        List<T> neighbors = graph.getMap().get(vertex);

        for (T neighbor : neighbors) {
            if (colorMap.get(neighbor).equals(currentColor)) {
                return false; 
            }
            if (colorMap.get(neighbor).equals("Uncolored") && !isBipartiteUtil(neighbor, colorMap, toggleColor(currentColor))) {
                return false; 
            }
        }

        return true; 
    }

    private String toggleColor(String currentColor) {
        return currentColor.equals("Color1") ? "Color2" : "Color1";
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2, true);
        graph.addEdge(2, 3, true);
        //graph.addEdge(1, 3, true);

        BipartiteGraphChecker<Integer> bipartiteChecker = new BipartiteGraphChecker<>(graph);
        boolean isBipartite = bipartiteChecker.isBipartite();

        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
