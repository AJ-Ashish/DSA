class Solution {
    public int minOperations(int[] nums) {

        int count = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                int num = nums[i];
                if(num <= nums[i-1]) {
                    count += (nums[i-1]-num) + 1;
                    num = Math.max(nums[i-1]+1, num);
                }
                // while(num <= nums[i-1]) {
                //     num = num+1;
                //     count++;
                // }
                nums[i] = num;
            }
        }
        return count;
    }
}