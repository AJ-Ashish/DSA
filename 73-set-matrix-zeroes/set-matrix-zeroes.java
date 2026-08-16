// class Solution {
//     private void setRow(int row,int n, int matrix[][]) {
//         for(int j=0; j<n; j++) {
//             if(matrix[row][j] != 0) {
//                 matrix[row][j] = -1;
//             }
//         }
//     }
//     private void setCol(int col,int m, int matrix[][]) {
//         for(int i=0; i<m; i++) {
//             if(matrix[i][col] != 0) {
//                 matrix[i][col] = -1;
//             }
//         }
//     }
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if( matrix[i][j] == 0) {
//                     setRow(i,n,matrix);
//                     setCol(j,m, matrix);
//                 }
//             }
//         }
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) { 
//                 if(matrix[i][j] == -1) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
// }



            // Better Solution 
            // TC = O(2 * n * m)
            // SC = (O(n) + O(m))

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;
        
//         int row[] = new int[m];
//         int col[] = new int[n];

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == 0) {
//                     row[i] = 1;
//                     col[j] = 1;
//                 }
//             }
//         }
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(row[i] == 1 || col[j] == 1) {
//                     matrix[i][j] = 0;
//                 } 
//             }
//         }
//      }
// }



            // Optimal approach 


class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n =matrix[0].length;

        boolean rowZero = false;
        boolean colZero = false;

        // Step 1: Check first row
        for(int j=0; j<n; j++) {
            if(matrix[0][j] == 0) {
                rowZero = true;
                break;
            }
        }

         // Step 2: Check first column 
        for(int i = 0; i<m; i++) {
            if(matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }
        

         // Step 3: Traverse the rest (excluding first row & col)
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0; //mark for col 
                    matrix[i][0]  = 0; // mark for row
                }
            }
        }
        // Order matters 
        // Step 4: Update the rest
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
         // Step 5: Handle first row
        if(rowZero ) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }
        // Step 6: Handle first col
        if(colZero ) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}