package Graph_Algorithms;

import java.util.*;

public class TopologicalSort {

    private int vertices;
    private List<List<Integer>> graph;

    public TopologicalSort(int vertices) {
        this.vertices = vertices;
        this.graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
    }

    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void dfs(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        int vertices = 6;
        TopologicalSort ts = new TopologicalSort(vertices);

        ts.addEdge(5, 2);
        ts.addEdge(5, 0);
        ts.addEdge(4, 0);
        ts.addEdge(4, 1);
        ts.addEdge(2, 3);
        ts.addEdge(3, 1);

        List<Integer> result = ts.topologicalSort();

        System.out.println("Topological Sorting Order:");
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }
}

