class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int suffixMin[] = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1; i>=0; i--) {
            min = Math.min(min, nums[i]);
            suffixMin[i] = min;
        }

        int leftMax = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            leftMax = Math.max(leftMax, nums[i]);

            int instability = leftMax - suffixMin[i];
            if(instability <= k) {
                return i;
            }
        }
        return -1;
    }
}