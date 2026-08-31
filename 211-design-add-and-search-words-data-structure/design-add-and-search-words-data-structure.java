
class TrieNode{
    boolean isEndOfWord = false;
    TrieNode children[] = new TrieNode[26];
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode crawler = root;

        for(int i=0; i<word.length(); i++ ) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }

    boolean searchUtil(TrieNode root, String word) {
        TrieNode crawler = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                for(int j=0; j<26; j++) {
                    if(crawler.children[j] != null) {
                        if(searchUtil(crawler.children[j], word.substring(i+1))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            int idx = ch - 'a';
            if(crawler.children[idx] == null) {
                return false;
            }
            crawler = crawler.children[idx];
        }
        return crawler.isEndOfWord;
    }
    
    public boolean search(String word) {
        return searchUtil(root,word);        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */