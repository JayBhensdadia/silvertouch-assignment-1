package JavaOne.Trie;

public class TrieUse {

    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("JAY");
        trie.add("JAYU");
        trie.add("VIJAY");
        trie.remove("JAY");
        System.out.println(trie.search("JAY"));

       


    }
}
