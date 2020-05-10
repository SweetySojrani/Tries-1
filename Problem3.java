// Time Complexity - O(n1 + m*n) where m1 is the number of characters in the sentence, m is the number of dictionary words,n is the average length of the dictionary word
// Space Complexity - O(mn) where m is the number of dictionary words,n is the average length of the dictionary word
// This Solution worked in LeetCode


class Solution {
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(){};
    }
    TrieNode root = new TrieNode();
    private void insert(String word){
        TrieNode curr = root;
        for(int i=0;i< word.length();i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null)
                curr.children[c - 'a']  = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String replaceWords(List<String> dict, String sentence) {
        for(String word : dict){
            insert(word);
        }
        StringBuilder sb = new StringBuilder();
        for(String word : sentence.split("\\s+")){
            if(sb.length() > 0)
                sb.append(" ");
            TrieNode curr = root;
            String replacement;
            for(int i=0;i< word.length();i++){
                char c = word.charAt(i);
                if(curr.children[c - 'a'] == null || curr.word != null) break;
                curr = curr.children[c - 'a']; 
            }
            if(curr.word != null)
                replacement = curr.word;
            else
                replacement = word;
            sb.append(replacement);
                
        }
        return sb.toString();
    }
}
