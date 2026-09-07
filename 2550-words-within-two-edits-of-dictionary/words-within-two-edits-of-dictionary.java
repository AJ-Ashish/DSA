class Solution {
    class TrieNode {
        boolean isEndOfWord = false;
        TrieNode children[] = new TrieNode[26];
    } 
    void insert(TrieNode root, String word) {
        TrieNode crawler = root;

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }
    boolean search(TrieNode node, String word, int index, int edits) {
        if(index == word.length()) {
            return node.isEndOfWord;
        }

        int idx = word.charAt(index) - 'a';

         // Option 1: same character
        if(node.children[idx] != null) {
            if(search(node.children[idx], word, index+1, edits)) {
                return true;
            };
        }
        if(edits < 2){
            for(int i=0; i<26; i++) {
                if(i == idx) continue;
                if(node.children[i] != null) {
                    if(search(node.children[i], word, index+1, edits+1)) {
                        return true;
                    };
                }
            }
        }
        return false;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        TrieNode root = new TrieNode();
        for(String word : dictionary ) {
            insert(root,word);
        }
        List<String> result = new ArrayList<>();

        for(String word : queries) {
            if(search(root, word, 0, 0)) {
                result.add(word);
            }
        }
        return result;
        
    }
}