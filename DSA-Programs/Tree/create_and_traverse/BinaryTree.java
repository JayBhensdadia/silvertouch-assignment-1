package Tree.create_and_traverse;

public class BinaryTree<T> {
    
    public Node<Integer> root;

    public BinaryTree(){
        this.root = new Node<Integer>(1);
        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);
        root.left.left = new Node<Integer>(4);
        //root.left.left.left = new Node<Integer>(5);
    }


    public static <T> void printTree(Node<T> root){
        if (root==null) {
            
            return;
        }
        System.out.print(root.data+": ");
        if(root.left!=null){System.out.print("L"+root.left.data+", ");}
        if(root.right!=null){System.out.println("R"+root.right.data+", ");}
        System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    //Left-Root-Right
    public static <T> void inorderTraversal(Node<T> root){
        if (root==null) {
            return;
        }
        
        inorderTraversal(root.left);
        System.out.print(root.data+", ");
        inorderTraversal(root.right);
    }

    //Root-Left-Right
    public static <T> void preorderTraversal(Node<T> root){
        if(root==null){ return; }
        System.out.print(root.data+", ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    //Left-Right-Root
    public static <T> void postorderTraversal(Node<T> root){
        if (root==null) { return;}
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+", ");
    }
}
