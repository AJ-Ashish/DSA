class Solution {
    public long largestPerimeter(int[] nums) {
        if(nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        long sum = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += (long)nums[i];
        }

        for(int i=nums.length-1; i>=0; i--) {
            if((sum - (long)nums[i]) > (long)nums[i]) {
                return sum;
            }
            sum -= (long)nums[i];
        }
        return sum == 0 ? -1 : sum;
    }
}