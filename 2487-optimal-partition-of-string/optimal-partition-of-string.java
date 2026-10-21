class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        int j = 0;
        while(j < n) {
            if(set.contains(s.charAt(j))) {
                count++;
                set.clear();
            }
            set.add(s.charAt(j));
            j++;
        }
        return count+1;
    }
}