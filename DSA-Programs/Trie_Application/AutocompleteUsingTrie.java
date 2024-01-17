package Trie_Application;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public List<String> autocomplete(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode node = findNode(prefix);
        if (node != null) {
            autocompleteHelper(node, prefix, suggestions);
        }
        return suggestions;
    }

    private TrieNode findNode(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                return null; 
            }
        }
        return current;
    }

    private void autocompleteHelper(TrieNode node, String currentPrefix, List<String> suggestions) {
        if (node.isEndOfWord) {
            suggestions.add(currentPrefix);
        }

        for (char ch : node.children.keySet()) {
            autocompleteHelper(node.children.get(ch), currentPrefix + ch, suggestions);
        }
    }
}

public class AutocompleteUsingTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");
        trie.insert("bat");

        
        List<String> suggestions = trie.autocomplete("ap");
        System.out.println("Autocomplete suggestions for 'ap': " + suggestions);

        suggestions = trie.autocomplete("ba");
        System.out.println("Autocomplete suggestions for 'ba': " + suggestions);
    }
}

