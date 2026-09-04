// If total digits in arr1 = N and total digits in arr2 = M:

// Time  = O(N + M)
// Space = O(N)

class Solution {
    class TrieNode {
        TrieNode children[] = new TrieNode[10];
    }
    
    void insert(TrieNode root, int num) {

        TrieNode crawler = root;
        String str = String.valueOf(num);
        for(int i=0; i<str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if(crawler.children[digit] == null) {
                crawler.children[digit] = new TrieNode();
            }
            crawler = crawler.children[digit];
        }
        
    }
    int findPrefix(TrieNode root,int num) {
        String str = String.valueOf(num);
        int count = 0;
        TrieNode crawler = root;

        for(int i=0; i<str.length(); i++) {
            int digit = str.charAt(i) - '0';

            if(crawler.children[digit] == null) {
                return count;
            }
            crawler = crawler.children[digit];
            count++;
        }
        return count;
    } 
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for(int num : arr1) {
            insert(root, num);
        }
        int maxCount = 0;
        for(int num : arr2) {
            int count = findPrefix(root,num);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
        
    }
}