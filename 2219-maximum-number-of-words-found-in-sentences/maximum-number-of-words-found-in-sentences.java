// Tc = O(n*m) 
// SC = O(m)

class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for(String sentence : sentences) {
            int currWords = sentence.split(" ").length;

            maxWords = Math.max(maxWords, currWords);
        }
        return maxWords;
    }
}


// class Solution {
//     public int mostWordsFound(String[] sentences) {

//         int maxWords = 0;

//         for(String sentence : sentences) {
//             int space = 0;

//             for (int i = 0; i < sentence.length(); i++) { 
//                 char ch = sentence.charAt(i);
//                 if(ch == ' ') {
//                     space++;
//                 }
//             }
//             int currWords = space+1;
//             maxWords = Math.max(maxWords, currWords);
//         }
//         return maxWords;
//     }
    
// }