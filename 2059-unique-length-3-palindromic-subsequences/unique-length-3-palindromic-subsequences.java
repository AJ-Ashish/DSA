class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> letters = new HashSet<>();
        int result = 0;

        for(char c : s.toCharArray()) {
            letters.add(c);
        }
        for(Character letter : letters) {
            int right_idx = -1;
            int left_idx = -1;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == letter) {
                    if(left_idx == -1) {
                        left_idx = i;
                    }
                    right_idx = i;
                }
                
            }
            HashSet<Character> temp = new HashSet<>();
            for(int middle = left_idx+1; middle <= right_idx-1; middle++) {
                temp.add(s.charAt(middle));
            }
            result += temp.size();
        }
        return result;
    }
}