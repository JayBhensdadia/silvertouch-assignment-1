package Graph.ConnectedComponents;

import Graph.create_and_basic_ops.Graph;

public class ConnectedComponents {

    public static void dfsUtil(Graph<Integer> graph, int vertex, boolean[] visisted){

        visisted[vertex] = true;
        System.out.print(vertex + " ");

        for (int v : graph.getMap().get(vertex)) {
            if(!visisted[v]){
                dfsUtil(graph, v, visisted);
            }
        }
    }
    public static void print(Graph<Integer> graph){
        boolean visisted[] =  new boolean[graph.getMap().keySet().size()];

        for (int vertex : graph.getMap().keySet()) {
            if (!visisted[vertex]) {
                dfsUtil(graph, vertex, visisted);
                System.out.println();
            }
        }
    }
}
