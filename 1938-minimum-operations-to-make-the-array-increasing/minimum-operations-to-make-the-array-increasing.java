class Solution {
    public int minOperations(int[] nums) {

        int count = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                if(nums[i] <= nums[i-1]) {
                    count += (nums[i-1]-nums[i]) + 1;
                    nums[i] = Math.max(nums[i-1]+1, nums[i]);
                }
                // while(num <= nums[i-1]) {
                //     num = num+1;
                //     count++;
                // }
            }
        }
        return count;
    }
}