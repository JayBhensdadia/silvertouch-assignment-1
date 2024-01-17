package Advanced_Data_Structures;

import java.util.HashMap;
import java.util.Map;

class SuffixTreeNode {
    Map<Character, SuffixTreeNode> children = new HashMap<>();
    int start;
    int end;
    SuffixTreeNode suffixLink;

    public SuffixTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class SuffixTree {
    private String text;
    private SuffixTreeNode root;
    private SuffixTreeNode activeNode;
    private int activeEdge;
    private int activeLength;
    private int remainingSuffixCount;

    public SuffixTree(String text) {
        this.text = text;
        root = new SuffixTreeNode(-1, -1);
        activeNode = root;
        activeEdge = -1;
        activeLength = 0;
        remainingSuffixCount = 0;

        buildSuffixTree();
    }

    private void buildSuffixTree() {
        for (int i = 0; i < text.length(); i++) {
            extendSuffixTree(i);
        }
    }

    private void extendSuffixTree(int pos) {
        remainingSuffixCount++;
        SuffixTreeNode lastCreatedNode = null;

        while (remainingSuffixCount > 0) {
            if (activeLength == 0) {
                activeEdge = pos;
            }

            char nextChar = text.charAt(pos);

            if (!activeNode.children.containsKey(nextChar)) {
                activeNode.children.put(nextChar, new SuffixTreeNode(pos, pos));
                if (lastCreatedNode != null) {
                    lastCreatedNode.suffixLink = activeNode;
                    lastCreatedNode = null;
                }
            } else {
                SuffixTreeNode next = activeNode.children.get(nextChar);
                if (walkDown(next)) {
                    continue;
                }

                if (text.charAt(next.start + activeLength) == nextChar) {
                    if (lastCreatedNode != null && activeNode != root) {
                        lastCreatedNode.suffixLink = activeNode;
                        lastCreatedNode = null;
                    }
                    activeLength++;
                    break;
                }

                int splitEnd = next.start + activeLength - 1;
                SuffixTreeNode splitNode = new SuffixTreeNode(next.start, splitEnd);
                activeNode.children.put(nextChar, splitNode);

                splitNode.children.put(text.charAt(pos), new SuffixTreeNode(pos, pos));
                next.start += activeLength;
                splitNode.children.put(text.charAt(next.start), next);

                if (lastCreatedNode != null) {
                    lastCreatedNode.suffixLink = splitNode;
                }

                lastCreatedNode = splitNode;
            }

            remainingSuffixCount--;
            if (activeNode == root && activeLength > 0) {
                activeLength--;
                activeEdge = pos - remainingSuffixCount + 1;
            } else if (activeNode != root) {
                activeNode = activeNode.suffixLink != null ? activeNode.suffixLink : root;
            }
        }
    }

    private boolean walkDown(SuffixTreeNode node) {
        if (activeLength >= edgeLength(node)) {
            activeEdge += edgeLength(node);
            activeLength -= edgeLength(node);
            activeNode = node;
            return true;
        }
        return false;
    }

    private int edgeLength(SuffixTreeNode node) {
        return Math.min(node.end, text.length() - 1) - node.start + 1;
    }

    public void printSuffixTree() {
        System.out.println("Suffix Tree:");
        printSuffixTree(root, "");
    }

    private void printSuffixTree(SuffixTreeNode node, String indent) {
        for (Map.Entry<Character, SuffixTreeNode> entry : node.children.entrySet()) {
            SuffixTreeNode child = entry.getValue();
            System.out.println(indent + text.substring(child.start, Math.min(child.end + 1, text.length())));
            printSuffixTree(child, indent + "  ");
        }
    }

    public static void main(String[] args) {
        String text = "banana";
        SuffixTree suffixTree = new SuffixTree(text);
        suffixTree.printSuffixTree();
    }
}
