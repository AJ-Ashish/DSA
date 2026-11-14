class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefix = new int[nums.size()+1];

        for(int i=0; i<nums.size(); i++) {
            prefix[i+1] = nums.get(i) + prefix[i];
        }
        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<=nums.size()-l; i++) {
            int j = i+l-1;
            while( j < nums.size() && j <= i+r-1){
                int sum = prefix[j+1] - prefix[i];
                if(sum > 0 && sum < minSum) {
                    minSum = sum;
                }
                j++;
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum ;
    }
}