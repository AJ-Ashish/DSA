class Solution {
    // Time:  O(bookings.length + n)
    // Space: O(n)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // Step 1 : create difference array
        int diff[] = new int[n];

        for(int[] booking  : bookings) {
            int start = booking[0];
            int end = booking[1];

            int x = booking[2];

            diff[start-1] += x;
            if(end < n) {
                diff[end] -= x;
            }            
        }
        // Step 2 : create prefix sum 
        int currSum = 0;
        int result[] = new int[n];
        for(int i=0; i<n; i++) {
            currSum += diff[i];
            result[i] = currSum;
        }
        return result;

    }
}