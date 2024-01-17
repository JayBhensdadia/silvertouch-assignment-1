import java.util.HashSet;
import java.util.Set;

class TrieNode {
    char value;
    boolean isEndOfWord;
    TrieNode[] children;

    public TrieNode(char value) {
        this.value = value;
        this.isEndOfWord = false;
        this.children = new TrieNode[26]; 
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(c);
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
}

public class SpellChecker {
    private Trie trie;

    public SpellChecker() {
        this.trie = new Trie();
    }

    public void buildDictionary() {
        String[] dictionary = {"apple", "banana", "orange", "pear", "peach", "grape", "watermelon"};
        for (String word : dictionary) {
            trie.insert(word.toLowerCase());
        }
    }

    public Set<String> suggestCorrections(String input) {
        Set<String> suggestions = new HashSet<>();
        suggestCorrections(trie.root, input, "", suggestions);
        return suggestions;
    }

    private void suggestCorrections(TrieNode node, String remaining, String current, Set<String> suggestions) {
        if (node.isEndOfWord) {
            suggestions.add(current);
        }

        if (remaining.isEmpty()) {
            return;
        }

        char nextChar = remaining.charAt(0);
        int index = nextChar - 'a';
        if (node.children[index] != null) {
            suggestCorrections(node.children[index], remaining.substring(1), current + nextChar, suggestions);
        }

        
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char substituteChar = (char) ('a' + i);
                suggestCorrections(node.children[i], remaining.substring(1), current + substituteChar, suggestions);
            }
        }

        
        suggestCorrections(node, remaining.substring(1), current, suggestions);
    }

    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.buildDictionary();

        String wordToCheck = "apple"; 
        boolean isCorrect = spellChecker.trie.search(wordToCheck.toLowerCase());

        if (isCorrect) {
            System.out.println(wordToCheck + " is spelled correctly.");
        } else {
            System.out.println(wordToCheck + " is misspelled.");
            
        }
    }
}
