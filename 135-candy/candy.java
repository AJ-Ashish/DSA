// class Solution {
//     // Time: (O(n)) — three linear passes.
//     // Space:(O(n)) — the candies array.
//     public int candy(int[] ratings) {

//         int[] candies = new int[ratings.length];
//         // Give every child at least one candy
//         Arrays.fill(candies, 1);

//         // Pass 1 Left to right
//         for(int i=1; i<ratings.length; i++) {
//             if(ratings[i] > ratings[i-1]) {
//                 candies[i] = candies[i-1]+1;
//             }
//         }
//         // Pass 2 right to Left 
//         for(int i=ratings.length-2; i>=0; i--) {
//             if(ratings[i] > ratings[i+1] ) {
//                 candies[i] = Math.max(candies[i], candies[i+1]+1);
//             }
//         }
//         int total = 0; 
//         for(int candy : candies) {
//             total += candy;
//         }
//         return total;
//     }
// }

// O(n) && O(1)

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candy = n;

        int i = 1;
        while(i < n) {
            if(ratings[i] == ratings[i-1]) {
                i++;
                continue;
            }

            // Increasing slope - peek
            int peek = 0;
            while(ratings[i] > ratings[i-1]) {
                peek++;
                candy+= peek;
                i++;

                if(i == n) {
                    return candy;
                }
            }

            // Decreasing slope 
            int dip = 0;
            while(i < n && ratings[i] < ratings[i-1]) {
                dip++;
                candy += dip;
                i++;
            }
            candy -= Math.min(peek, dip);
        }
        return candy;
    }
}