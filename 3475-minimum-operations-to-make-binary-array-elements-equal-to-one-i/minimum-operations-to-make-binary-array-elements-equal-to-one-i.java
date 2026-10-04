class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operation = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                if(i + 2 >= n) {
                    return -1;
                }
                int j = i;
                while(j <= i+2) {
                    nums[j] = nums[j] == 1 ? 0 : 1;
                    j++;
                }
                operation++;
            }
        }
        return operation;
    } 
}