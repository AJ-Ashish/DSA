class Solution {
    // m = trips.length.
    // TC=O(m) SC=O(1)
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1001;
        int diff[] = new int[n];

        for(int[] trip : trips) {
            int start = trip[1];
            int end = trip[2];

            int passengers = trip[0];

            diff[start] += passengers;
            diff[end] -= passengers;
            
        }

        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += diff[i];
            if(sum > capacity) {
                return false;
            }
        }
        return true;
    }
}