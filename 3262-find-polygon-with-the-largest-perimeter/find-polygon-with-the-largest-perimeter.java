class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long cummSum = 0;
        long perimeter = -1;
        
        for(int i=0; i<nums.length; i++) {
            // Since cummSum is already a long, comparing it with nums[i] 
            // automatically promotes nums[i] to a long. Explicit cast here is optional.
            if((long)nums[i] < cummSum) {
                perimeter = cummSum+nums[i];
            }
            cummSum += (long)nums[i];
        }

        return perimeter;
    }
}