package Tree.level_order;

import java.util.LinkedList;
import java.util.Queue;

import Tree.create_and_traverse.Node;

public class LevelOrderTraversal {

    

    public static <T> void levelorderTraversal(Node<T> root){
        if(root==null){ return; }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left!=null) { queue.add(node.left);}
            if(node.right!=null){queue.add(node.right);}
            System.out.print(node.data+ ", ");
        }
    }
}
