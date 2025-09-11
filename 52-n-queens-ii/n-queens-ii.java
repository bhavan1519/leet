class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        int count = NQueens(board, 0);
        return count;
    }
    private int NQueens(boolean[][] board, int row){
        int n = board.length;
        if(row == n){
            return 1;
        }
        int count = 0;
        for(int col = 0; col < n; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true; 
                count += NQueens(board, row + 1); 
                board[row][col] = false; 
            }
        }

        return count;
    }
    
    private static boolean isSafe(boolean[][] board, int row, int col) {
  
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        for (int i = 1; i <= Math.min(row, board.length - 1 - col); i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }
}