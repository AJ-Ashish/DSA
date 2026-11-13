// // Binary Search in 2D

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length; 

        int low = 0;
        int high = m * n - 1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            int row = mid/n;
            int col = mid%n;

            if(matrix[row][col] == target) {
                return true;
            }else if(matrix[row][col] < target) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return false;
    }
}

// Staircase search O(m+n)

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int row = 0;
//         int col = matrix[0].length-1;

//         while(row < matrix.length && col >= 0) {

//             if(matrix[row][col] < target) {
//                 row++;
//             }else if(matrix[row][col] > target) {
//                 col--;
//             }else {
//                 return true;
//             }
//         }
//         return false;
//     }
// }