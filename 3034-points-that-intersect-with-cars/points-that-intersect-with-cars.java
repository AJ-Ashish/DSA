class Solution {
    // m = nums.size().
    // TC=O(m+100)=O(m), SC= O(100)=O(1)
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = 101;
        int[] diff = new int[n];

        for(List<Integer> num : nums ) {
            int start = num.get(0);
            int end = num.get(1);

            diff[start] += 1;
            if(end+1 < n) {
                diff[end+1] -= 1;
            }
        }

        int point = 0;
        int sum = 0;

        for(int i=1; i<n; i++) {
            sum += diff[i];
            if(sum > 0) {
                point++;
            }
        }
        return point;
    } 
}