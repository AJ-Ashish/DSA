class Solution {
    // Tc = O(nlogn + k)  SC = O(1)
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int prev = Integer.MIN_VALUE;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            int minVal = nums[i]-k;

            if(prev < minVal) {
                prev = minVal;
                count++;
            }else if(prev < nums[i]+k) {
                prev = prev + 1;
                count++;
            }
        }
        return count;
    }
}