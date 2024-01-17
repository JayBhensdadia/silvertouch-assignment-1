package Graph_Algorithms;

import java.util.*;

public class FordFulkerson {

    private static final int INF = Integer.MAX_VALUE;
    private int vertices;
    private int[][] capacity;
    private List<List<Integer>> residualGraph;

    public FordFulkerson(int vertices, int[][] capacity) {
        this.vertices = vertices;
        this.capacity = new int[vertices][vertices];
        this.residualGraph = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            residualGraph.add(new ArrayList<>());
            for (int j = 0; j < vertices; j++) {
                this.capacity[i][j] = capacity[i][j];
            }
        }
    }

    public int maxFlow(int source, int sink) {
        int maxFlow = 0;
        int[] parent = new int[vertices];

        while (bfs(source, sink, parent)) {
            int pathFlow = INF;

            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, capacity[u][v]);
            }

            
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                capacity[u][v] -= pathFlow;
                capacity[v][u] += pathFlow;

                
                residualGraph.get(u).add(v);
                residualGraph.get(v).remove(Integer.valueOf(u));
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private boolean bfs(int source, int sink, int[] parent) {
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : residualGraph.get(u)) {
                if (!visited[v] && capacity[u][v] > 0) {
                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    public static void main(String[] args) {
        int vertices = 6;
        int[][] capacity = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        FordFulkerson fordFulkerson = new FordFulkerson(vertices, capacity);
        int maxFlow = fordFulkerson.maxFlow(0, 5);

        System.out.println("Maximum Flow: " + maxFlow);
    }
}
