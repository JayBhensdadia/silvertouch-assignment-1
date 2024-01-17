package Graph_Algorithms;

import java.util.*;

public class StronglyConnectedComponents {

    private Map<Integer, List<Integer>> graph;
    private Map<Integer, List<Integer>> reversedGraph;

    public StronglyConnectedComponents(int vertices) {
        graph = new HashMap<>();
        reversedGraph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            reversedGraph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
        reversedGraph.get(to).add(from);
    }

    public List<List<Integer>> findSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.size()];

        
        for (int vertex : graph.keySet()) {
            if (!visited[vertex]) {
                fillOrder(vertex, visited, stack);
            }
        }

        
        Map<Integer, List<Integer>> transposedGraph = transposeGraph();

        
        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                List<Integer> scc = new ArrayList<>();
                dfsTransposed(vertex, visited, scc, transposedGraph);
                sccs.add(scc);
            }
        }

        return sccs;
    }

    private void fillOrder(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                fillOrder(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }

    private Map<Integer, List<Integer>> transposeGraph() {
        Map<Integer, List<Integer>> transposedGraph = new HashMap<>();

        for (int vertex : reversedGraph.keySet()) {
            transposedGraph.put(vertex, new ArrayList<>());
        }

        for (int vertex : reversedGraph.keySet()) {
            for (int neighbor : reversedGraph.get(vertex)) {
                transposedGraph.get(neighbor).add(vertex);
            }
        }

        return transposedGraph;
    }

    private void dfsTransposed(int vertex, boolean[] visited, List<Integer> scc, Map<Integer, List<Integer>> transposedGraph) {
        visited[vertex] = true;
        scc.add(vertex);

        for (int neighbor : transposedGraph.get(vertex)) {
            if (!visited[neighbor]) {
                dfsTransposed(neighbor, visited, scc, transposedGraph);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        StronglyConnectedComponents sccFinder = new StronglyConnectedComponents(vertices);

        sccFinder.addEdge(0, 1);
        sccFinder.addEdge(1, 2);
        sccFinder.addEdge(2, 0);
        sccFinder.addEdge(1, 3);
        sccFinder.addEdge(3, 4);

        List<List<Integer>> sccs = sccFinder.findSCCs();

        System.out.println("Strongly Connected Components:");
        for (List<Integer> scc : sccs) {
            System.out.println(scc);
        }
    }
}
