class Solution {
     boolean validate(char[][] board, int sr, int sc, int er, int ec) {
            HashSet<Character> set = new HashSet<>();
            for(int row = sr; row<=er; row++) {
                for(int col = sc; col<=ec ; col++) {
                    if(board[row][col] == '.') continue;
                    if(set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
            return true;
        }
    public boolean isValidSudoku(char[][] board) {

        // Step 1 validate row 
        for(int row=0; row < board.length; row++) {
            HashSet<Character> set = new HashSet<>();
            for(int col = 0; col< board[0].length; col++) {
                if(board[row][col] == '.') continue;
                if(set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }
        // Step 2 validate col 
        for(int col = 0; col< board[0].length; col++) {
            HashSet<Character> set = new HashSet<>();
            for(int row = 0; row< board.length; row++) {
                 if(board[row][col] == '.') continue;
                if(set.contains(board[row][col])) {
                    return false;
                }
                set.add(board[row][col]);
            }
        }

        // Step 3 validate 3*3 grid
        for(int sr=0; sr < board.length; sr+=3) {
            int er = sr+2;
            for(int sc = 0; sc< board[0].length; sc+=3) {
                int ec = sc+2;
                if(validate(board,sr,sc,er,ec) == false) {
                    return false;
                };  
            }
        }

       
            return true;
    }
}