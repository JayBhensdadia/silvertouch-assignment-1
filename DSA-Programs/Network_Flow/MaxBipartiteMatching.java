package Network_Flow;
import java.util.*;

class BipartiteGraph {
    private int leftVertices;
    private int rightVertices;
    private Map<Integer, List<Integer>> graph;

    public BipartiteGraph(int leftVertices, int rightVertices) {
        this.leftVertices = leftVertices;
        this.rightVertices = rightVertices;
        this.graph = new HashMap<>();
    }

    public void addEdge(int leftVertex, int rightVertex) {
        if (!graph.containsKey(leftVertex)) {
            graph.put(leftVertex, new ArrayList<>());
        }
        graph.get(leftVertex).add(rightVertex);
    }

    public int findMaxMatching() {
        int[] matching = new int[rightVertices + 1];
        Arrays.fill(matching, -1);

        int matchingSize = 0;
        boolean augmentedPathExists = true;

        while (augmentedPathExists) {
            boolean[] visited = new boolean[leftVertices + 1];
            augmentedPathExists = false;

            for (int leftVertex = 1; leftVertex <= leftVertices; leftVertex++) {
                if (matching[leftVertex] == -1 && dfs(leftVertex, graph, matching, visited)) {
                    augmentedPathExists = true;
                    matchingSize++;
                }
            }
        }

        return matchingSize;
    }

    private boolean dfs(int leftVertex, Map<Integer, List<Integer>> graph, int[] matching, boolean[] visited) {
        if (visited[leftVertex]) {
            return false;
        }

        visited[leftVertex] = true;

        if (!graph.containsKey(leftVertex)) {
            return false;
        }

        for (int rightVertex : graph.get(leftVertex)) {
            if (matching[rightVertex] == -1 || dfs(matching[rightVertex], graph, matching, visited)) {
                matching[rightVertex] = leftVertex;
                return true;
            }
        }

        return false;
    }
}

public class MaxBipartiteMatching {

    public static void main(String[] args) {
        // Example usage
        BipartiteGraph bipartiteGraph = new BipartiteGraph(4, 4);
        bipartiteGraph.addEdge(1, 1);
        bipartiteGraph.addEdge(1, 2);
        bipartiteGraph.addEdge(2, 2);
        bipartiteGraph.addEdge(3, 1);
        bipartiteGraph.addEdge(3, 3);
        bipartiteGraph.addEdge(4, 2);

        int maxMatchingSize = bipartiteGraph.findMaxMatching();
        System.out.println("Maximum Bipartite Matching Size: " + maxMatchingSize);
    }
}

