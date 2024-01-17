package Searching_Algorithms.Search_in_BST;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    
    public void inorderTraversal() {
        System.out.print("DFS: ");
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.key + " ");
            inorderTraversal(root.right);
        }
    }

    
    public void breadthFirstSearch() {
        if (root == null) {
            return;
        }

        System.out.print("BFS: ");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.key + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.inorderTraversal();
        bst.breadthFirstSearch();
    }
}
