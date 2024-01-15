package Tree.is_balanced;

import Tree.create_and_traverse.Node;
import Tree.find_height.HeightFinder;

public class Balanced {
    public static <T> boolean isBalanced(Node<T> root){
        if(root==null){ return true;}
        if(Math.abs(HeightFinder.getHeight(root.left) - HeightFinder.getHeight(root.right)) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
