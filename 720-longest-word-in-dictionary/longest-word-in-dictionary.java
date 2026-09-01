

class Solution {
    class TrieNode{
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];
    }
    TrieNode root = new TrieNode();
    String result = "";
    void insert(String word) {
        TrieNode crawler = root;
        for(int i=0; i<word.length(); i++) {
            char ch =  word.charAt(i);
            int idx = ch - 'a';

            if(crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }
    boolean canBeBuilt(String word) {
        TrieNode crawler = root;
        for(int i=0; i<word.length(); i++) {
            char ch =  word.charAt(i);
            int idx = ch - 'a';

            if(crawler.children[idx] == null ) {
                return false;
            }
            crawler = crawler.children[idx];

            if(!crawler.isEndOfWord) {
                return false;
            }
        }
        return crawler.isEndOfWord;
       
    }
    public String longestWord(String[] words) {
        for(String word : words) {
            insert(word);
        }

        for(String word : words) {
            if(canBeBuilt(word)) {
                if(word.length() > result.length()) {
                    result = word;
                }else if (word.length() == result.length() && word.compareTo(result) < 0) {
                    result = word;
                }
                 
            }
        }
        return result;
        
    }
}