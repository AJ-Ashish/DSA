// Difference array + prefix sum
// If n = logs.length:

// TC: O(n + 101) → effectively O(n)
// SC: O(101) → effectively O(1) because the year range is fixed

class Solution {
    public int maximumPopulation(int[][] logs) {
        int years[] = new int[101]; //constraint

        for(int log[] : logs) {
            years[log[0]-1950]++;
            years[log[1]-1950]--;
        }
        int currentPopulation = 0;
        int maxPopulation = 0;
        int ans = 1950;

        for(int i=0; i<101; i++) {
            currentPopulation += years[i];
            if(currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                ans = i+1950;
            }
        }
        return ans;
    }
}