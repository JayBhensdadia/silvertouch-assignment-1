package Tree.inorder_without_recursion;

import Tree.create_and_traverse.BinaryTree;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree<>();
        InorderWithoutRecursion.print(tree.root);
    }
}
