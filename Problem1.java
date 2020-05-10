

class Trie {
    
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        public TrieNode(){}
    }
    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();  
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i =0;i < word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)  return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i =0;i < prefix.length();i++){
            char c = prefix.charAt(i);
            if(curr.children[c - 'a'] == null)  return false;
            curr = curr.children[c - 'a'];
        }
        return true;    
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
