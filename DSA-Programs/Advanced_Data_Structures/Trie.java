package Advanced_Data_Structures;

class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    public TrieNode(char data){
        this.data = data;
        this.isTerminating = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }

}

public class Trie {
    private TrieNode root;
    

    
    public Trie(){
        root = new TrieNode('\0');
    }

    

    
    private void addHelper(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'A';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
            root.childCount++;
			
		}
		addHelper(child, word.substring(1));

	}

    
	public void add(String word){
		addHelper(root, word);
        
	}

    
    private boolean searchHelper(String word, TrieNode root){
        if(root==null){
            return false;
        }
        
        if(word.length()==0){
            return root.isTerminating;
        }
        
        char ch = word.charAt(0);
        int index = ch - 'A';
        TrieNode temp = root.children[index];
        if(temp==null){
            return false;
        }else{
            return searchHelper(word.substring(1),temp);
        }
    }
    

    
	public boolean search(String word){
		return searchHelper(word,root);
	}


    
    private void removeHelper(String word, TrieNode root){

        if(word.length()==0){
            root.isTerminating = false;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null){
            return;
        }
        
        removeHelper(word.substring(1), child);
        if(!child.isTerminating && child.childCount==0){
            root.children[childIndex] = null;
            root.childCount--;
        }
        

    }

    
    public void remove(String word){
        removeHelper(word, root);
        
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("JAY");
        trie.add("JAYU");
        trie.add("VIJAY");
        //trie.remove("JAY");
        System.out.println(trie.search("JAY"));
    }
}
