package Tree.inorder_without_recursion;

import java.util.Stack;

import Tree.create_and_traverse.Node;

public class InorderWithoutRecursion {

   
    
    public static <T> void print(Node<T> root){
        Stack<Node<T>> stack = new Stack<>();

        Node<T> current = root;
        

        while (true) {
            if (current!=null) {
                stack.push(current);
                current = current.left;
            }
            else{
                if (stack.isEmpty()) {
                    break;
                }

                current = stack.peek();
                System.out.print(current.data+", ");
                stack.pop();
                current = current.right;
            }
        }



       
    }
}
