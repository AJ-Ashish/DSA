class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                size = size * (c-'0');
            }else {
                size++;
            }
        }
        for(int i = s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            k %= size;

            if(k == 0 && !Character.isDigit(c)) {
                return String.valueOf(c);
            }else if(Character.isDigit(c)) {
                size = size/(c-'0');
            }else {
                size = size - 1;
            }
        }
        return "";
    }
}