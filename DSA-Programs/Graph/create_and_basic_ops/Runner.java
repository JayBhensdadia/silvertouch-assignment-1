package Graph.create_and_basic_ops;

import Graph.DFS.DFS;

public class Runner {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>();

        graph.addEdge(0, 1, true);
        graph.addEdge(0, 2, true);
        graph.addEdge(0, 3, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(2, 4, true);

        

        DFS.dfs(0, graph);




    }
}
