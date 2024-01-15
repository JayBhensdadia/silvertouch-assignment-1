package JavaOne.Trie;


public class Trie {
    private TrieNode root;
    

    //constructor
    public Trie(){
        root = new TrieNode('\0');
    }

    

    //add Helper
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

    //add
	public void add(String word){
		addHelper(root, word);
        
	}

    //search Helper
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
    

    //search
	public boolean search(String word){
		return searchHelper(word,root);
	}


    //remove helper
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

    //remove
    public void remove(String word){
        removeHelper(word, root);
        
    }
}
