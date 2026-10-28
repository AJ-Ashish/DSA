class Solution {
    // Time: (O(n)) — three linear passes.
    // Space:(O(n)) — the candies array.
    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        // Give every child at least one candy
        Arrays.fill(candies, 1);

        // Pass 1 Left to right
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }
        // Pass 2 right to Left 
        for(int i=ratings.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1] ) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        int total = 0; 
        for(int candy : candies) {
            total += candy;
        }
        return total;
    }
}