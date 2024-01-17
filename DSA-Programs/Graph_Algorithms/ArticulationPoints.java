package Graph_Algorithms;

import java.util.*;

public class ArticulationPoints {

    private int vertices;
    private List<List<Integer>> graph;
    private int[] disc; 
    private int[] low; 
    private boolean[] visited; 
    private int time;

    public ArticulationPoints(int vertices) {
        this.vertices = vertices;
        this.graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        this.disc = new int[vertices];
        this.low = new int[vertices];
        this.visited = new boolean[vertices];
        this.time = 0;
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from); 
    }

    public List<Integer> findArticulationPoints() {
        List<Integer> articulationPoints = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, -1, articulationPoints);
            }
        }
        return articulationPoints;
    }

    private void dfs(int u, int parent, List<Integer> articulationPoints) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                dfs(v, u, articulationPoints);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] >= disc[u] && parent != -1) {
                    articulationPoints.add(u);
                }
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (parent == -1 && children > 1) {
            articulationPoints.add(u);
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArticulationPoints apFinder = new ArticulationPoints(vertices);

        apFinder.addEdge(0, 1);
        apFinder.addEdge(1, 2);
        apFinder.addEdge(2, 0);
        apFinder.addEdge(1, 3);
        apFinder.addEdge(1, 4);
        apFinder.addEdge(1, 6);
        apFinder.addEdge(3, 5);
        apFinder.addEdge(4, 5);

        List<Integer> articulationPoints = apFinder.findArticulationPoints();

        System.out.println("Articulation Points:");
        for (int point : articulationPoints) {
            System.out.println(point);
        }
    }
}

