class Solution {
    // TC = O(n2) SC = O(n2)
    public int[][] generateMatrix(int n) {
        int result[][] = new int[n][n];
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int degree = 0;
        int num = 1;
        while(left <= right && top <= down ) {
            if(degree == 0) {
                for(int i=left; i<=right; i++) {
                    result[top][i] = num;
                    num++;
                }
                top++;
            }
            if(degree == 1) {
                for(int i=top; i<=down; i++) {
                    result[i][right] = num;
                    num++;
                }
                right--;
            }
            if(degree == 2) {
                for(int i=right; i>=left; i--) {
                    result[down][i] = num;
                    num++;
                }
                down--;
            }
             if(degree == 3) {
                for(int i=down; i>=top; i--) {
                    result[i][left] = num;
                    num++;
                }
                left++;
            }
            degree++;
            if(degree == 4) {
                degree = 0;
            }
        }
        return result;
    }
}