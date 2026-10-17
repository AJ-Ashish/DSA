class Solution {
    // Let \(n\) be the number of bars and \(M\) be the maximum cost.
    // \(O(n+M)\)	\(O(M)\)
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for(int cost : costs) {
            maxCost = Math.max(cost, maxCost);
        }
        int[] freq = new int[maxCost+1];
        for(int cost : costs) {
            freq[cost]++;
        }

        int count = 0;
        for(int cost=1; cost<=maxCost; cost++) {

            while(freq[cost] > 0) {
                if(coins < cost) {
                    return count;
                }
                coins -= cost;
                freq[cost]--;
                count++;
            }
        }
        return count;
    }
}