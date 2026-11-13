class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // TC = O(m+n) SC = O(1)

        //  Staircase search O(m+n) or (or Top-Right / Bottom-Left Corner Search) 
        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] < target) {
                row++;
            }else if(matrix[row][col] > target) {
                col--;
            }else {
                return true;
            }
        }
        return false;
    }
}