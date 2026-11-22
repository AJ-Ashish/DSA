class Solution {
    public boolean checkString(String s) {
        boolean firstB = false;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(firstB == true && ch == 'a') {
                return false;
            }
            if(!firstB && ch == 'b') {
                firstB = !firstB;
            }
        }
        return true;
    }
}