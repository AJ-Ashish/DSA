class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int n = 51;
        // Create difference array
        int[] diff = new int[n];

        for(int[] range : ranges) {
            int start = range[0];
            int end = range[1];

            diff[start] += 1;
            if(end + 1 < n) {
                diff[end+1] -= 1;
            }
        }
        // Check coverage while calculating prefix sum 
        int sum = 0;
        for(int i=1; i<n; i++) {
            sum += diff[i];

            if(i >= left && i <= right && sum == 0) {
                return false;
            }
        } 
        return true;
    }
}