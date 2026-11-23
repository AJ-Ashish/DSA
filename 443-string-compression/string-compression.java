class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int pointer = 0; // write index
        int i=0;  // read index
        while(i < n) {
            char currChar = chars[i];
            int count = 0;
            while(i < n && chars[i] == currChar) {
                i++;
                count++;
            }
            chars[pointer++] = currChar; 
            
            if(count > 1) {
                for(char digit : String.valueOf(count).toCharArray()) {
                    chars[pointer++] = digit;
                }
            }
        }

        return pointer;
    }
}