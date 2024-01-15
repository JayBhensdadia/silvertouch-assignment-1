package Tree.create_and_traverse;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree =new BinaryTree();

        BinaryTree.inorderTraversal(tree.root);
        System.out.println();
        BinaryTree.preorderTraversal(tree.root);
        System.out.println();
        BinaryTree.postorderTraversal(tree.root);
    }
}
