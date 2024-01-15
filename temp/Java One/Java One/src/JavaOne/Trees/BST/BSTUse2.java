package JavaOne.Trees.BST;

public class BSTUse2 {
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
        b.delete(9);
        b.printTree();
    }
}
