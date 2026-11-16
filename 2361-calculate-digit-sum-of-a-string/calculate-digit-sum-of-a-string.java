class Solution {
    public String digitSum(String s, int k) {
        if(s.length() <= k) return s;
        StringBuilder sb = new StringBuilder(s);
        while(true) {
            int sum = 0;
            int length = 0;
            StringBuilder temp = new StringBuilder();

            for(int i=0; i<sb.length(); i++) {
                char c  = sb.charAt(i); 
                sum = sum + (c - '0');
                length++;
                if(i != sb.length()-1 && length == k) {
                    temp.append(sum);
                    sum = 0;
                    length = 0;
                }
            }
            temp.append(sum);
            sb = temp;
            if(sb.length() <= k) break;
        }
        return sb.toString();
    }
}