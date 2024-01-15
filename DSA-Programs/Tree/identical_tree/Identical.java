package Tree.identical_tree;

import Tree.create_and_traverse.Node;

public class Identical {
    public static <T> boolean check(Node<T> r1, Node<T> r2){
        if(r1==null && r2==null){ return true;}

        if(r1!=null && r2!=null){
            return check(r1.left, r2.left) && check(r1.right, r2.right);
        }

        return false;
    }
}
