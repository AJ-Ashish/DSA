class Solution {
    // TC = O(n) SC =O(1)
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] lastIdx = new int[26];

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            lastIdx[c-'a'] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(seen[c-'a'] == true) {
                continue;
            }
            while(sb.length() > 0 && sb.charAt(sb.length()-1) > c && lastIdx[sb.charAt(sb.length()-1)-'a'] > i) {
                seen[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            
            sb.append(c);
            seen[c-'a'] = true;
        }
        return sb.toString();
    }
}