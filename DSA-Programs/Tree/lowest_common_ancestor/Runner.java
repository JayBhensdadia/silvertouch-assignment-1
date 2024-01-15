package Tree.lowest_common_ancestor;

import Tree.create_and_traverse.BinaryTree;
import Tree.create_and_traverse.Node;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree<>();

        Node<Integer> node = LCA.lca(tree.root, tree.root.right, tree.root.left);
        System.out.println(node.data);
    }
}
