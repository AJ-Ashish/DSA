class Solution {
    // TC = O(n + 26) -> O(n) length of the string 
    // SC = O(26) -> O(1) 
    public int minDeletions(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] == 0) continue;
            while(freq[i] > 0 && set.contains(freq[i])) {
                freq[i]--;
                count++;
            }
            if (freq[i] > 0) {
                set.add(freq[i]);
            }
            
        }
        return count;
    }
}