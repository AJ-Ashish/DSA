class Solution {
    public long largestPerimeter(int[] nums) {
        if(nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        long sum = nums[0] + nums[1];
        if(nums.length == 3) {
            if(nums[2] >= sum) {
                return -1;
            }else {
                return sum+nums[2];
            }
        }
        
        for(int i=2; i<nums.length; i++) {
            sum += nums[i];
        }

        for(int i=nums.length-1; i>=0; i--) {
            if((sum - nums[i]) > nums[i]) {
                return sum;
            }
            sum -= nums[i];
        }
        return sum == 0 ? -1 : sum;
    }
}