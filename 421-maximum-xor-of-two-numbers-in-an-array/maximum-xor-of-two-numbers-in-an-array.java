// 1. insert all number binary bits in trie
// 2. find max xor number 




class Solution {
    class TrieNode{
        TrieNode left;
        TrieNode right ;
    }
    void insert(TrieNode root, int num) {
        TrieNode crawler = root;
        for(int i=31; i>=0; i--) {
            int ith_bit = (num >> i) & 1;
            if(ith_bit == 0) {
                if(crawler.left == null) {
                    crawler.left = new TrieNode();
                }
                crawler = crawler.left;
            }else {
                if(crawler.right == null) {
                    crawler.right = new TrieNode();
                }
                crawler = crawler.right;
            }
        }
    }
    int findMaxXor(TrieNode root, int num ) {
        int maxXor = 0;
        TrieNode crawler = root;
        for(int i=31; i>=0; i--) {
            int ith_bit = (num >> i) & 1;
            if(ith_bit == 1) {
                if(crawler.left != null) {
                    maxXor += Math.pow(2,i)*1;
                    crawler = crawler.left;
                }else {
                    // maxXor = maxXor += Math.pow(2,i) * 0;
                    crawler = crawler.right;
                }
            }else { 
                if(crawler.right != null) {
                    maxXor += Math.pow(2,i)*1;
                    crawler = crawler.right;
                }else {
                    // maxXor = maxXor += Math.pow(2,i) * 0;
                    crawler = crawler.left;
                }
            }
            
        }
        return maxXor;
        
    }   
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int num : nums) {
            insert(root,num);
        }

        int maxResult = 0;

        for(int i=0; i<nums.length; i++) {
            int temp = findMaxXor(root, nums[i]);
            maxResult = Math.max(maxResult, temp);
        }
        return maxResult;
    }
}