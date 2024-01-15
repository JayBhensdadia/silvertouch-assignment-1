package Tree.lowest_common_ancestor;



import Tree.create_and_traverse.Node;

public class LCA {

    /*
     * Algorithm
     * 
     * 1. if root is null or equal to either of node1 and node2 then root is the lca
     * 
     * 2.make recursive call for both left (ansLeft) and right(ansRight) subtree
     *      
     *      if(ansLeft==null)-> return ansRight
     *      if(ansRight==null) -> return ansLeft
     *      if both null -> return root;
     */
    

    public static <T> Node<T> lca(Node<T> root, Node<T> node1, Node<T> node2){
        if(root==null || root == node1 || root==node2){ return root;}

        Node<T> left = lca(root.left, node1, node2);
        Node<T> right = lca(root.right, node1, node2);

        if(left==null){
            return right;
        }else if(right == null){
            return left;
        }else{ // if both are null then root is the lca
            return root;
        }
    }
}
