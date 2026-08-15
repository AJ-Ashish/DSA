class Solution {
    // Two step
    // 1. Transpose 
    // 2. Reverse each row
    // TC = O(n2) SC = O(1)
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m-1; i++) {
            for(int j=i+1; j<n; j++) {
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            } 
        }

        for(int i=0; i<m; i++) {
            int first = 0;
            int last = n-1;

            while(first < last) {
                int temp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = temp;
                first++;
                last--;
            } 
        }

    }
}