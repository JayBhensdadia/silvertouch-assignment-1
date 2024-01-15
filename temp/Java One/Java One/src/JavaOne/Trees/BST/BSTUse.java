package JavaOne.Trees.BST;

import JavaOne.Trees.BinaryTrees.BinaryTreeNode;
import JavaOne.Trees.BinaryTrees.BinaryTreeUse;

public class BSTUse {
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k){

        if(root==null){
            return false;
        }

        if(root.data==k){
            return true;
        }else if(root.data > k){
            return searchInBST(root.left, k);
        }else{
            return searchInBST(root.right, k);
        }

    }
    
    public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root){
        if(root==null){
            return new IsBSTReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
        }

        IsBSTReturn left = isBST2(root.left);
        IsBSTReturn right = isBST2(root.right);
        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data,Math.max(left.max,right.max));
        boolean isBST = true;
        if(left.max >= root.data ){
            isBST = false;
        }
        if(right.min < root.data){
            isBST = false;
        }
        if(!left.isBST || !right.isBST){
            isBST = false;
        }

        return new IsBSTReturn(min, max, isBST);

    }

    public static boolean isBST(BinaryTreeNode<Integer> root){
        return isBST2(root).isBST;
    }

    public static boolean isBST3(BinaryTreeNode<Integer> root,int min, int max){
        if(root==null){
            return true;
        }

        if(root.data < min || root.data > max){
            return false;
        }

        return isBST3(root.left, min, root.data-1) && isBST3(root.right, root.data, max);

    }
    
    public static void main(String[] args) {
        BinaryTreeUse bt = new BinaryTreeUse();
        BinaryTreeNode<Integer> root  = bt.takeInputBetter(true, 0, false);
        
        System.out.println(isBST(root));
        //System.out.println(searchInBST(root, 11));

    }
}

