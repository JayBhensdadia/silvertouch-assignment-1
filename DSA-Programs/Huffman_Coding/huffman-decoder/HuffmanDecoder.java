import java.util.HashMap;
import java.util.Map;

class HuffmanNode {
    char data;
    HuffmanNode left, right;

    public HuffmanNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class HuffmanDecoder {

    public static String decode(String encodedText, HuffmanNode root) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedText.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;
            if (current.data != '\0') {
                decodedText.append(current.data);
                current = root; 
            }
        }

        return decodedText.toString();
    }

    public static void main(String[] args) {
        
        HuffmanNode root = buildHuffmanTree();

       
        String encodedMessage = "1001011101101111000";

        
        String decodedMessage = decode(encodedMessage, root);

        System.out.println("Encoded Message: " + encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }

    private static HuffmanNode buildHuffmanTree() {
        
        HuffmanNode root = new HuffmanNode('\0');
        root.left = new HuffmanNode('\0');
        root.right = new HuffmanNode('A');
        root.left.left = new HuffmanNode('B');
        root.left.right = new HuffmanNode('C');

        return root;
    }
}
