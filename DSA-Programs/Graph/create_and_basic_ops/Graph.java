package Graph.create_and_basic_ops;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {

   
    private HashMap< T, List<T> > map = new HashMap<>();


    public void addVertex(T vertex){
        map.put(vertex, new LinkedList<>());
    }
    

    public void addEdge(T source, T destination , boolean bidirectional){

        if (!map.containsKey(source)) { map.put(source, new LinkedList<>());}

        if (!map.containsKey(destination)) {map.put(destination, new LinkedList<>());}

        if (bidirectional) {
            map.get(source).add(destination);
            map.get(destination).add(source);
        }else{
            map.get(source).add(destination);
        }
    }


    public void removeVertex(T vertex){
        if(!map.containsKey(vertex)){ 
            System.out.println("vertex does not exist");
            return;
        }

        map.remove(vertex);

        for (T v : map.keySet()) {
            
            map.get(v).remove(vertex);
        }

    }


    public void removeEdge(T source, T destination){
        if (!map.containsKey(source) || !map.containsKey(destination)) {
            System.out.println("vertex does not exist");
            return;
        }

        List<T> list = map.get(source);

        if (list.contains(destination)) {list.remove(destination);}
        else{
            System.out.println("edge does not exist");
        }
        
    }

    public void printList(List<T> list){
        for (T item : list) {
            System.out.print(item+" ");
        }
        System.out.println();
    }
    public void printGraph(){
        for (T vertex : map.keySet()) {
            System.out.print(vertex + ": ");
            printList(map.get(vertex));
        }
    }


    public HashMap<T, List<T>> getMap() {
        return map;
    }

    
}