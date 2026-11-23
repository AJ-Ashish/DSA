class Solution {
    // In Java, indexOf() searches for a character inside a string.
    // If the character is found, indexOf() returns its position (index).
    // If the character is not found, it returns -1.
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
    public boolean halvesAreAlike(String s) {

        int countLeft = 0;
        int countRight = 0;

        for(int i=0; i<s.length()/2; i++) {
            if(isVowel(s.charAt(i))) {
                countLeft++;
            }
            if(isVowel(s.charAt(i+s.length()/2))) {
                countRight++;
            }
        }
        return countLeft == countRight;
    }
}