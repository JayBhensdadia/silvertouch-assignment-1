package Tree.is_balanced;

import Tree.create_and_traverse.BinaryTree;

public class Runner {
    public static void main(String[] args) {
         BinaryTree tree =new BinaryTree();
         System.out.println(Balanced.isBalanced(tree.root));
    }
}
