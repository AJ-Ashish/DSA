class Solution {
    public int longestSubsequence(String s, int k) {
        
        int length = 0;
        long powerVal = 1; // 2^0
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '0') {
                length++;
            }else if(powerVal <= k) {
                k -= powerVal;
                length++;

            }
            if(powerVal <= k ) {
                powerVal *= 2;
            }
            
        }
        return length;
    }
}