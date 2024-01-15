package Tree.level_order;

import Tree.create_and_traverse.BinaryTree;
import Tree.is_balanced.Balanced;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree =new BinaryTree();
 
        LevelOrderTraversal.levelorderTraversal(tree.root);
        
    }
}
