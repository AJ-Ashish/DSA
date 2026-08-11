class Solution {
    public boolean rotateString(String s, String goal) {
        // TC & SC = O(n)
        if(s.length() != goal.length()) {
            return false;
        }

        String temp = s + s;
        return temp.contains(goal);
    }
}