// class Solution {
//     public void generateStrings(String str, int n, List<String> list) {
//         if(n == str.length()) {
//             list.add(str);
//             return;
//         }
//         generateStrings(str+"0", n, list);
//         generateStrings(str+"1", n, list);
//     }
//     public String findDifferentBinaryString(String[] nums) {
//         List<String> list = new ArrayList<>();        
//         generateStrings("", nums.length, list);

//         HashSet<String> set = new HashSet<>();

//         for(String num : nums) {
//             set.add(num);
//         }
//         for(int i=0; i<list.size(); i++) {
//             String str = list.get(i);
//             if(!set.contains(str)) {
//                 return str;
//             }
//         }
//         return new String("");
//     }
// }


// Approach: Cantor's Diagonal Argument (Optimal)
// Time Complexity: O(N) – We iterate through N strings once.
// Space Complexity: O(N) – StringBuilder stores N characters.
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<nums.length; i++) {
            if(nums[i].charAt(i) == '0') {
                ans.append('1');
            }else {
                ans.append('0');
            }
        }
        return ans.toString();
    }
}