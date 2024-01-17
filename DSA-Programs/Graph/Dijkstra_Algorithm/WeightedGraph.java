package Graph.Dijkstra_Algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightedGraph<T> {

    private Map<T, List<WeightedEdge<T>>> map = new HashMap<>();

    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    public void addWeightedEdge(T source, T destination, int weight) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }

        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(new WeightedEdge<>(destination, weight));
    }

    public void printGraph() {
        for (T vertex : map.keySet()) {
            System.out.print(vertex + ": ");
            for (WeightedEdge<T> edge : map.get(vertex)) {
                System.out.print("(" + edge.getDestination() + ", " + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public Map<T, Integer> dijkstra(T start) {
        Map<T, Integer> distances = new HashMap<>();
        for (T vertex : map.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(start, 0);

        PriorityQueue<Node<T>> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node<>(start, 0));

        while (!priorityQueue.isEmpty()) {
            T currentVertex = priorityQueue.poll().getVertex();

            for (WeightedEdge<T> neighbor : map.get(currentVertex)) {
                T nextVertex = neighbor.getDestination();
                int newDistance = distances.get(currentVertex) + neighbor.getWeight();

                if (newDistance < distances.get(nextVertex)) {
                    distances.put(nextVertex, newDistance);
                    priorityQueue.add(new Node<>(nextVertex, newDistance));
                }
            }
        }

        return distances;
    }

    class WeightedEdge<T> {
        private T destination;
        private int weight;
    
        public WeightedEdge(T destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    
        public T getDestination() {
            return destination;
        }
    
        public int getWeight() {
            return weight;
        }
    }
    
    //node to be stored in priority queue
    class Node<T> implements Comparable<Node<T>> {
        private T vertex;
        private int distance;
    
        public Node(T vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    
        public T getVertex() {
            return vertex;
        }
    
        public int getDistance() {
            return distance;
        }
    
        @Override
        public int compareTo(Node<T> other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    

    public static void main(String[] args) {
        WeightedGraph<Character> graph = new WeightedGraph<>();
        graph.addWeightedEdge('A', 'B', 1);
        graph.addWeightedEdge('A', 'C', 4);
        graph.addWeightedEdge('B', 'C', 2);
        graph.addWeightedEdge('B', 'D', 5);
        graph.addWeightedEdge('C', 'D', 1);
        graph.addWeightedEdge('D', 'A', 7);

        System.out.println("Original Graph:");
        graph.printGraph();

        char startVertex = 'A';
        Map<Character, Integer> distances = graph.dijkstra(startVertex);

        System.out.println("\nShortest Distances from Vertex " + startVertex + ":");
        for (char vertex : distances.keySet()) {
            System.out.println("To " + vertex + ": " + distances.get(vertex));
        }
    }
}


