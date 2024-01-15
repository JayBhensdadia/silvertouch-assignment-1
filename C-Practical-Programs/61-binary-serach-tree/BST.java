
class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data){
        this.data = data;
    }
    
}


public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    //isPresent Helper
    private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return false;
        }

        //if root is the node we are finding
        if(root.data==x){
            return true;
        }

        //if node we are finding is greater then root then
        //only search right sub tree
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

        
        // if tree is empty then create root
        if(root==null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(data);
            return node;
        }

        //if data is less then root insert in left sub tree
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

                // find the inorder successor of the node
                //Copy contents of the inorder successor to the node, and delete the inorder successor.

                BinaryTreeNode<Integer> t = root;
                t = t.right;
                while(t.left!=null){
                    t = t.left;
                }
                int temp = t.data;
                root = delete(t, temp);
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

    public static void main(String[] args) {
        BST b = new BST();

        b.insert(9);
        b.insert(5);
        b.insert(2);
        b.insert(7);
        b.insert(1);
        b.insert(3);
        b.insert(6);
        b.insert(8);
        b.insert(11);
        b.printTree();
        System.out.println("---------------------------------");
        b.delete(11);
        b.printTree();
        System.out.println("---------------------------------");
        b.delete(5);
        b.printTree();
    }

    
}
