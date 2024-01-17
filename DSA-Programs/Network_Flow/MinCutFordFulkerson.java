package Network_Flow;
import java.util.*;

class FordFulkerson {
    private static final int INF = Integer.MAX_VALUE;
    private int[][] capacity;
    private int[][] residualCapacity;
    private int[] parent;
    private int source;
    private int sink;

    public FordFulkerson(int[][] capacity, int source, int sink) {
        this.capacity = capacity;
        this.source = source;
        this.sink = sink;
        this.parent = new int[capacity.length];
        initializeResidualCapacity();
    }

    public int findMinCut() {
        int maxFlow = 0;

        while (augmentPath()) {
            int pathFlow = INF;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualCapacity[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualCapacity[u][v] -= pathFlow;
                residualCapacity[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        List<Edge> minCutEdges = new ArrayList<>();

        for (int i = 0; i < capacity.length; i++) {
            for (int j = 0; j < capacity.length; j++) {
                if (parent[i] != -1 && parent[j] == -1 && capacity[i][j] > 0) {
                    minCutEdges.add(new Edge(i, j, capacity[i][j]));
                }
            }
        }

        System.out.println("Minimum Cut Edges:");
        for (Edge edge : minCutEdges) {
            System.out.println(edge);
        }

        return maxFlow;
    }

    private boolean augmentPath() {
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        parent[source] = source;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < capacity.length; v++) {
                if (parent[v] == -1 && residualCapacity[u][v] > 0) {
                    parent[v] = u;
                    queue.offer(v);
                }
            }
        }

        return parent[sink] != -1;
    }

    private void initializeResidualCapacity() {
        int n = capacity.length;
        residualCapacity = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                residualCapacity[i][j] = capacity[i][j];
            }
        }
    }
}

class Edge {
    int start, end, capacity;

    public Edge(int start, int end, int capacity) {
        this.start = start;
        this.end = end;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "(" + start + " -> " + end + ", Capacity: " + capacity + ")";
    }
}

public class MinCutFordFulkerson {

    public static void main(String[] args) {
        
        int[][] capacity = {
                {0, 10, 5, 15},
                {0, 0, 4, 0},
                {0, 0, 0, 10},
                {0, 0, 0, 0}
        };

        int source = 0;
        int sink = 3;

        FordFulkerson fordFulkerson = new FordFulkerson(capacity, source, sink);
        int maxFlow = fordFulkerson.findMinCut();

        System.out.println("Maximum Flow: " + maxFlow);
    }
}
