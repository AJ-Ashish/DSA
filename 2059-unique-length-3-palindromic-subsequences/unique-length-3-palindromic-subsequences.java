
class Solution {
    // Tc = O(n + 26n) -> O(n) SC = O(26) -> O(1)
    // Time: O(n) Auxiliary Space: O(1)
    public int countPalindromicSubsequence(String s) {
        // store first and last occurence of a letter 
        int[][] arr = new int[26][2];
        int result = 0;

        for(int i=0; i<26; i++) {  //26
            arr[i][0] = -1;
            arr[i][1] = -1;
        }

        for(int i=0; i<s.length(); i++) {  //O(n)
            char ch = s.charAt(i);
            if(arr[ch-'a'][0] == -1) {  //left most occurance
                arr[ch-'a'][0] = i;
            }
            arr[ch-'a'][1] = i; // right most occurance
        }

        for(int i=0; i<arr.length; i++) {  //O(26)
            int left_idx = arr[i][0];
            int right_idx = arr[i][1];
            if(left_idx == -1) {
                continue;
            }
            HashSet<Character> temp = new HashSet<>();
            for(int middle = left_idx+1; middle <=right_idx-1; middle++) {  //O(n)
                temp.add(s.charAt(middle));
            }
            result += temp.size();
        }
        return result;
    }

}

// class Solution {
// TC = O(26 * 2n) SC = O(26)
//     public int countPalindromicSubsequence(String s) {
//         HashSet<Character> letters = new HashSet<>();
//         int result = 0;

//         for(char c : s.toCharArray()) {
//             letters.add(c);
//         }
//         for(Character letter : letters) {
//             int right_idx = -1;
//             int left_idx = -1;

//             for(int i=0; i<s.length(); i++) {
//                 if(s.charAt(i) == letter) {
//                     if(left_idx == -1) {
//                         left_idx = i;
//                     }
//                     right_idx = i;
//                 }
                
//             }
//             HashSet<Character> temp = new HashSet<>();
//             for(int middle = left_idx+1; middle <= right_idx-1; middle++) {
//                 temp.add(s.charAt(middle));
//             }
//             result += temp.size();
//         }
//         return result;
//     }
// }