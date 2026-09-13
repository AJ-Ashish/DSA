class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];

        int uniqueCount = 0;

        for(char ch : sentence.toCharArray()) {
            int idx = ch - 'a';

            if(!seen[idx]) {
                seen[idx] = true;
                uniqueCount++;
            }
            if(uniqueCount == 26) {
                return true;
            }
        }
        return false;
    }
}