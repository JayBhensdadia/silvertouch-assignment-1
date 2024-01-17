package Interval_Trees;

import java.util.List;
import java.util.ArrayList;

class Interval {
    int low;
    int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public boolean overlapsWith(Interval other) {
        return this.low <= other.high && other.low <= this.high;
    }

    public boolean contains(int point) {
        return this.low <= point && point <= this.high;
    }

    @Override
    public String toString() {
        return "[" + low + ", " + high + "]";
    }
}

class IntervalNode {
    Interval interval;
    int maxHigh; // Max high value in the subtree rooted at this node.
    IntervalNode left;
    IntervalNode right;

    public IntervalNode(Interval interval) {
        this.interval = interval;
        this.maxHigh = interval.high;
        this.left = null;
        this.right = null;
    }
}

public class IntervalTree {

    private IntervalNode root;

    public void insert(Interval interval) {
        root = insert(root, interval);
    }

    private IntervalNode insert(IntervalNode node, Interval interval) {
        if (node == null) {
            return new IntervalNode(interval);
        }

        int cmp = interval.low - node.interval.low;

        if (cmp < 0) {
            node.left = insert(node.left, interval);
        } else {
            node.right = insert(node.right, interval);
        }

        // Update maxHigh for the current node.
        node.maxHigh = Math.max(node.maxHigh, interval.high);

        return node;
    }

    public void delete(Interval interval) {
        root = delete(root, interval);
    }

    private IntervalNode delete(IntervalNode node, Interval interval) {
        if (node == null) {
            return null;
        }

        int cmp = interval.low - node.interval.low;

        if (cmp < 0) {
            node.left = delete(node.left, interval);
        } else if (cmp > 0) {
            node.right = delete(node.right, interval);
        } else {
            // Node to be deleted found

            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children, get the inorder successor (smallest
            // in the right subtree)
            node.interval = findMin(node.right).interval;

            // Delete the inorder successor
            node.right = delete(node.right, node.interval);
        }

        // Update maxHigh for the current node.
        node.maxHigh = Math.max(getMaxHigh(node.left), getMaxHigh(node.right));

        return node;
    }

    private IntervalNode findMin(IntervalNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public List<Interval> search(Interval queryInterval) {
        List<Interval> result = new ArrayList<>();
        search(root, queryInterval, result);
        return result;
    }

    private void search(IntervalNode node, Interval queryInterval, List<Interval> result) {
        if (node == null) {
            return;
        }

        if (node.interval.overlapsWith(queryInterval)) {
            result.add(node.interval);
        }

        // If left child's maxHigh is greater than or equal to query low, search left subtree
        if (node.left != null && node.left.maxHigh >= queryInterval.low) {
            search(node.left, queryInterval, result);
        }

        // If the query low is greater than the current node's low, search right subtree
        if (queryInterval.low > node.interval.low) {
            search(node.right, queryInterval, result);
        }
    }

    private int getMaxHigh(IntervalNode node) {
        return (node != null) ? node.maxHigh : Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        IntervalTree intervalTree = new IntervalTree();

        // Insert intervals
        intervalTree.insert(new Interval(15, 20));
        intervalTree.insert(new Interval(10, 30));
        intervalTree.insert(new Interval(17, 19));
        intervalTree.insert(new Interval(5, 20));
        intervalTree.insert(new Interval(12, 15));
        intervalTree.insert(new Interval(30, 40));

        // Print intervals in the tree
        System.out.println("Intervals in the tree:");
        intervalTree.inorderTraversal(intervalTree.root);

        // Search for intervals overlapping with a query interval
        Interval queryInterval = new Interval(14, 16);
        List<Interval> result = intervalTree.search(queryInterval);

        // Print the search result
        System.out.println("\nIntervals overlapping with " + queryInterval + ":");
        for (Interval interval : result) {
            System.out.println(interval);
        }

        // Delete an interval
        Interval intervalToDelete = new Interval(15, 20);
        intervalTree.delete(intervalToDelete);

        // Print intervals in the tree after deletion
        System.out.println("\nIntervals in the tree after deletion:");
        intervalTree.inorderTraversal(intervalTree.root);
    }

    private void inorderTraversal(IntervalNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.interval);
            inorderTraversal(node.right);
        }
    }
}

