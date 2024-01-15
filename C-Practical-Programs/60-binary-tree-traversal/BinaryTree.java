
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

class BinaryTree {


	Node root;

	BinaryTree() { root = null; }

	// left root right
	void printInorder(Node node)
	{
		if (node == null)
			return;

		printInorder(node.left);

		System.out.print(node.key + " ");


		printInorder(node.right);
	}

	// root left right
    void printPreorder(Node node)
    {
        if (node == null)
            return;
 
        System.out.print(node.key + " ");
 

        printPreorder(node.left);
 
        printPreorder(node.right);
    }

	// left right root
    void printPostorder(Node node)
    {
        if (node == null)
            return;
 

        printPostorder(node.left);
 

        printPostorder(node.right);
 
        System.out.print(node.key + " ");
    }

	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);


		System.out.println("Inorder traversal of binary tree is");
		tree.printInorder(tree.root);
        System.out.println();

        System.out.println("Preorder traversal of binary tree is");
		tree.printPreorder(tree.root);
        System.out.println();

        System.out.println("Postorder traversal of binary tree is");
		tree.printPostorder(tree.root);
        System.out.println();
	}
}
