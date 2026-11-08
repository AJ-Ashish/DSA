// Approach 1 : sorting tc = O(N log N)
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         for(int i=0; i<nums.length; i++) {
//             if(nums[i] != i) {
//                 return i;
//             }
//         }
//         return n;

//     }
// }


// Approach 2 : Mathmatical formula( optimal ) O(n)

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n*(n+1)/2;

        int actualSum = 0;
        for(int num : nums) {
            actualSum += num;
        }
        int missing = expectedSum - actualSum;
        return missing;
    }
}

// Approach 3 : XOR  Optimal O(n) (also optimal)
//  a ^ a = 0
//  a ^ 0 = a
// a ^ b = b ^ a
// class Solution {
//     public int missingNumber(int[] nums) {
//         int xor = nums.length;
//         for(int i=0; i<nums.length; i++) {
//             xor = xor ^ (i ^ nums[i]);
//         }
//         return xor;
//     }
// }