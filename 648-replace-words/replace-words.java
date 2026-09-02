
class TrieNode {
    boolean isEndOfWord = false;
    TrieNode children[] = new TrieNode[26];
}
class Solution {

    TrieNode root = new TrieNode();

    void insert(List<String> dictionary) {
        for(String word : dictionary ) {
            TrieNode crawler = root;
            for(int i=0; i<word.length();i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';

                if(crawler.children[idx] == null) {
                    crawler.children[idx] = new TrieNode();
                }   
                crawler = crawler.children[idx];
            }
            crawler.isEndOfWord = true;
        }
    }
    String replaceWord(String word) {
        if(word.length() == 0) {
            return "";
        }
        TrieNode crawler = root;
        for(int i=0; i<word.length();i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if(crawler.children[idx] == null) {
                return word;
            }
            crawler = crawler.children[idx];
            if(crawler.isEndOfWord) {
                return word.substring(0,i+1);
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        insert(dictionary);
        StringBuilder result = new StringBuilder();
        String words[] = sentence.split(" ");
        for(int i=0; i<words.length; i++) {
            String word = replaceWord(words[i]);
            result.append(word);
            if(i != words.length-1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}