

import java.util.*;

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

public class AnagramFinderTrie {
    private Trie trie;
    private Set<String> anagrams;

    public AnagramFinderTrie() {
        this.trie = new Trie();
        this.anagrams = new HashSet<>();
    }

    public void buildDictionary(String[] dictionary) {
        for (String word : dictionary) {
            trie.insert(word.toLowerCase());
        }
    }

    public Set<String> findAnagrams(String inputWord) {
        this.anagrams.clear();
        findAnagrams(trie.root, inputWord.toCharArray(), new StringBuilder(), new boolean[inputWord.length()]);
        return anagrams;
    }

    private void findAnagrams(TrieNode node, char[] inputArray, StringBuilder currentWord, boolean[] visited) {
        if (currentWord.length() == inputArray.length) {
            if (trie.search(currentWord.toString())) {
                anagrams.add(currentWord.toString());
            }
            return;
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                currentWord.append(inputArray[i]);

                int index = inputArray[i] - 'a';
                if (node.children[index] != null) {
                    findAnagrams(node.children[index], inputArray, currentWord, visited);
                }

                visited[i] = false;
                currentWord.deleteCharAt(currentWord.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"listen", "silent", "enlist", "bad", "adb", "dab", "hello", "world"};

        AnagramFinderTrie anagramFinder = new AnagramFinderTrie();
        anagramFinder.buildDictionary(dictionary);

        String inputWord = "silent"; 

        Set<String> anagrams = anagramFinder.findAnagrams(inputWord);

        if (anagrams.isEmpty()) {
            System.out.println("No anagrams found for " + inputWord);
        } else {
            System.out.println("Anagrams of " + inputWord + ": " + anagrams);
        }
    }
}
