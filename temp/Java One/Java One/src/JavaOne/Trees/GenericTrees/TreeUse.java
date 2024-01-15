package JavaOne.Trees.GenericTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {


    //creating temporary tree
    public static TreeNode<Integer> tempTree(){
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        TreeNode<Integer> n1 = new TreeNode<Integer>(1);
        TreeNode<Integer> n2 = new TreeNode<Integer>(2);
        TreeNode<Integer> n3 = new TreeNode<Integer>(3);
        TreeNode<Integer> n4 = new TreeNode<Integer>(4);

        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        TreeNode<Integer> n5 = new TreeNode<Integer>(5);
        TreeNode<Integer> n6 = new TreeNode<Integer>(6);

        n2.children.add(n5);
        n2.children.add(n6);

        return root;

    }


    //printing tree
    public static void printTree(TreeNode<Integer> root){
        
        //this is not base case 
        //this is special case
        if(root==null){
            return;
        }

        System.out.print(root.data+": ");
        for(TreeNode<Integer> i : root.children){
            System.out.print(i.data+" ");
        }
        System.out.println();
        for(TreeNode<Integer> i : root.children){
            printTree(i);
           
        }
        
    }


    //number of nodes
    public static int numOfNodes(TreeNode<Integer> root){
        if(root==null){
            return 0;
        }

        int count = 0;
        for(TreeNode<Integer> i: root.children){
            int temp = numOfNodes(i);
            count += temp;
        }
        return 1 + count;

    }

    //take input level wise 
    public static TreeNode<Integer> takeInput(){

        Scanner sc = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.print("Enter root data: ");
        int rootData = sc.nextInt();
        if(rootData==-1){
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> front = pendingNodes.poll();
            System.out.print("Enter the number of children of "+front.data+" : ");
            int numOfChild = sc.nextInt();
            for (int i = 0; i < numOfChild; i++) {
                System.out.print("Enter the "+i+"th child data for "+ front.data+" : ");
                int childData = sc.nextInt();

                TreeNode<Integer> childNode = new TreeNode<>(childData);
                front.children.add(childNode);
                pendingNodes.add(childNode);

            }
        }

        return root;

    }
    public static void main(String[] args) {
        
        TreeNode<Integer> root = takeInput();
        printTree(root);
        System.out.println("number of nodes = "+numOfNodes(root));
    }
}
