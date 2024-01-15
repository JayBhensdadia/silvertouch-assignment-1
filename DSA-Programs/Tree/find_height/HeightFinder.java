package Tree.find_height;

import Tree.create_and_traverse.Node;

public class HeightFinder {
    public static <T> int getHeight(Node<T> root){
        if (root==null) {return 0;}
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
