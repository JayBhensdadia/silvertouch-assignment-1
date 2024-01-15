package JavaOne.Trees.BinaryTrees;

public class BinaryTreeUse2 {

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }

        if(root.left==null && root.right==null){
            return null;
        }

        BinaryTreeNode<Integer> tempLeft = removeLeafNodes(root.left);
        BinaryTreeNode<Integer> tempRight = removeLeafNodes(root.right);
        return root;
    }

    public static void main(String[] args) {
        
        

    }
}
