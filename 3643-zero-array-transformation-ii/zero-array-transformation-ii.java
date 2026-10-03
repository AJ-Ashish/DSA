class Solution {
    // TC = O(q * (q + n)) - (nq + q^2)
    // SC = O(n)
    public boolean canMakeZero(int[] nums, int[][] queries, int k) {

        int n = nums.length;
        int[] diff = new int[n];

        for(int i=0; i<=k; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int x = queries[i][2];

            diff[start] += x;
            if(end + 1 < n) {
                diff[end+1] -= x;
            }
        }

        int cummSum = 0;
        for(int i=0; i<n; i++) {
            cummSum += diff[i];
            diff[i] = cummSum;

            if(nums[i] - diff[i] > 0) {
                return false;
            }
        }
        return true;
     }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Already zero
        boolean allZero = true;

        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return 0;
        }

        // Gives tle

        // // Try using first 1, first 2, first 3... queries
        // for (int k = 0; k <= queries.length; k++) {

        //     if (canMakeZero(nums, queries, k)) {
        //         return k;
        //     }
        // }

        // Optimal 

        // O(n + logq * (q + n))
        // Auxiliary space O(n)

        int l = 0;
        int r = q-1; 
        int result = -1;
        while(l <= r) {
            // check till mid index 
            int mid = l + (r-l)/2;

            if(canMakeZero(nums, queries, mid) == true) {
                result = mid+1;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return result;
    }
}