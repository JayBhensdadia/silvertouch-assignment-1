package Tree.identical_tree;

import Tree.create_and_traverse.BinaryTree;
import Tree.create_and_traverse.Node;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree1 =new BinaryTree();
        BinaryTree tree2 = new BinaryTree();

        // tree2.root.right.left = new Node<Integer>(11);

        System.out.println(Identical.check(tree1.root, tree2.root));
    }
}
