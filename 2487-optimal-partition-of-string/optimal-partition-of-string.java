import java.util.*;

class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (set.contains(ch)) {
                count++;
                set.clear();
            }

            set.add(ch);
        }

        return count;
    }
}