package JavaOne.Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BinaryTreeUse {

    //printing the tree
    public static void printTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    //detailed print
    public static void printTree2(BinaryTreeNode<Integer> root){
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
        printTree2(root.left);
        printTree2(root.right);
    }

    //take input 
    public static BinaryTreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter node data : ");
        int nodeData = sc.nextInt();
        if(nodeData==-1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(nodeData);
        BinaryTreeNode<Integer> leftTemp = takeInput();
        BinaryTreeNode<Integer> rightTemp = takeInput();
        root.left = leftTemp;
        root.right = rightTemp;
        return root;
    }

    //taking input better
    public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        
        if(isRoot){
            System.out.println("Enter node data : ");
        }else{
            if(isLeft){
                System.out.println("Enter Left child of "+parentData+" ");
            }else{
                System.out.println("Enter Right child of "+parentData+" ");
            }
        }

        Scanner sc = new Scanner(System.in);
        
        int nodeData = sc.nextInt();
        if(nodeData==-1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(nodeData);
        BinaryTreeNode<Integer> leftTemp = takeInputBetter(false,root.data,true);
        BinaryTreeNode<Integer> rightTemp = takeInputBetter(false,root.data,false);
        root.left = leftTemp;
        root.right = rightTemp;
        return root;
    }

    // counting number of nodes
    public static int numberOfNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }

        int leftNodes = numberOfNodes(root.left);
        int rightNodes = numberOfNodes(root.right);
        return leftNodes+rightNodes+1;

    }

    //largest node
    public static int largest(BinaryTreeNode<Integer> root){
        if(root == null){
            return -1;
        }

        int leftLargest = largest(root.left);
        int rightLargest = largest(root.right);
        return Math.max(root.data,Math.max(leftLargest, rightLargest));
    }
   
    //number of leaf nodes
    public static int numberOfLeafNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }

        int leftLeaves = numberOfLeafNodes(root.left);
        int rightLeaves = numberOfLeafNodes(root.right);
        return leftLeaves+rightLeaves;
    }
   
    //printing the nodes at depth K
    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root, int k){
        if(root == null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
            return;
        }

        printNodesAtDepthK(root.left, k-1);
        printNodesAtDepthK(root.right, k-1);

    }

    //remove leaf nodes
    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }

        if(root.left==null && root.right==null){
            return null;
        }

        BinaryTreeNode<Integer> tempLeft = removeLeafNodes(root.left);
        BinaryTreeNode<Integer> tempRight = removeLeafNodes(root.right);
        root.left = tempLeft;
        root.right = tempRight;
        return root;
    }

    //height of tree
    public static int height(BinaryTreeNode<Integer> root) {
		
        if(root == null){
            return 0;
        }
        
        int heightLeft = height(root.left);
        int heightRight = height(root.right);
        return 1+Math.max(heightLeft,heightRight);
	}

    //is tree balanced?
    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if(root==null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight-rightHeight)>1){

            return false;
        }

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isLeftBalanced && isRightBalanced;
        

        
    }

    // is balanced? (better)
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root){

        if(root==null){
            return new BalancedTreeReturn(0, true);
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right);

        boolean isBal = true;
        int height = 1+ Math.max(leftOutput.height, rightOutput.height);
        if(Math.abs(leftOutput.height - rightOutput.height)>1){
            isBal = false;
        }

        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        return new BalancedTreeReturn(height, isBal);

    }
    
    //taking input level wise
    public static BinaryTreeNode<Integer> takeInputLevelWise(){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter root data:");
        int rootData = sc.nextInt();
        if(rootData==-1){
            return null;
        }

        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();

        pendingChildren.add(rootNode);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("enter left child of "+front.data);
            int left = sc.nextInt();
            if(left!=-1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("enter right child of "+front.data);
            int right = sc.nextInt();
            if(right!=-1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return rootNode;

    }
    
    
    //root to node path
    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x){
        if(root==null){
            return null;
        }
        if(root.data==x){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);
        if(leftOutput!=null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
        if(rightOutput!=null){
            rightOutput.add(root.data);
            return rightOutput;
        }

        return null;
    }
    public static void main(String[] args) {
        
        //BinaryTreeNode<Integer> root = takeInputBetter(true,0,true);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printTree2(root);

        ArrayList<Integer> ans = nodeToRootPath(root, 11);
        System.out.println(ans);
        //System.out.println("number of Nodes = "+numberOfNodes(root));
        //System.out.println("largest node = "+largest(root));
        //System.out.println("number of leaf nodes = " + numberOfLeafNodes(root));

        //printNodesAtDepthK(root, 1);

        //System.out.println(isBalancedBetter(root).isBalanced);

        
    }
}
