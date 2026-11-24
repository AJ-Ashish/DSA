class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int j=0; j<strs[0].length(); j++) {
            int prev = 0;
            for(int i=0; i<strs.length; i++) {
                char ch = strs[i].charAt(j);
                if(prev > ch - 96) {
                    count++;
                    break;
                }
                prev = ch - 96;
            }
        }
        return count;
    }
}