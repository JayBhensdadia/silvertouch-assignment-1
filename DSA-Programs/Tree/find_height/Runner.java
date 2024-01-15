package Tree.find_height;

import Tree.create_and_traverse.BinaryTree;

public class Runner {
    public static void main(String[] args) {
        BinaryTree tree =new BinaryTree();

        int height = HeightFinder.getHeight(tree.root);
        System.out.println(height);
    }
}
