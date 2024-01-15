package JavaOne.Trees.BST;
import JavaOne.Trees.BinaryTrees.BinaryTreeNode;


public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    //isPresent Helper
    private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        if(root.data>x){
            return isPresentHelper(root.left, x);
        }else{
            return isPresentHelper(root.right, x);
        }
    }

    //isPresent
    public boolean isPresent(int x){
       return isPresentHelper(root, x);
    }

    //insert helper - O(h)
    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data){

        //here root means the argument given in the function
        //not the class variable

        if(root==null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(data);
            return node;
        }

        if(root.data<=data){
            root.right = insert(root.right, data);
        }else{
            root.left = insert(root.left, data);
        }
        return root;
    }

    //insert
    public void insert(int data){
        root = insert(root, data);
        size++;
    }

    //delete helper - O(h)
    private BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return null;
        }
        if(root.data<x){
            root.right =  delete(root.right, x);
            return root;
        }else if(root.data>x){
            root.left = delete(root.left, x);
            return root;
        }else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left!=null && root.right==null ){
                return root.left;
            }else if(root.left==null && root.right!=null){
                return root.right;
            }else{
                BinaryTreeNode<Integer> t = root;
                while(t.left!=null){
                    t = t.left;
                }
                int temp = t.data;
                root = delete(root.right, temp);
                root.data = temp;
                return root;
            }
        }
    }

    //delete
    public void delete(int data){
        root = delete(root,data);
        size--;
    }

    //size of the tree
    public int size(){
        return size;
    }

    //printTree helper
    private static void printTreeHelper(BinaryTreeNode<Integer> root){
       
        //here root means the argument given in the function
        //not the class variable
       
        if(root==null){
            return;
        }
        System.out.print(root.data + " : ");
        if(root.left!=null){
            System.out.print("L"+root.left.data+" , ");
        }
        if(root.right!=null){
            System.out.print("R"+root.right.data);
        }
        System.out.println();
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }
    
    //printTree
    public void printTree(){
        printTreeHelper(root);
        
    }
}
