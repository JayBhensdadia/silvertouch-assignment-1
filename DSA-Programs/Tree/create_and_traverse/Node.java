package Tree.create_and_traverse;

public class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;
    
    public Node(T data){
        this.data = data;
    }
}