class Solution {

    int count = 0;
    public int totalNQueens(int n) {
        char[][] queen = new char[n][n];
        for (int i=0; i<n; i++) {
            Arrays.fill(queen[i],'.');
        }
        solveUntil(queen, 0);
        return count;
    }

    public boolean isValid(char[][] queen, int row, int col) {

        for (int i=col-1; i>=0; i--) {
            if (queen[row][i] == 'Q') {
                return false;
            }
        }

        for (int i=row-1, j =col-1; i>=0 && j>=0; i--, j--) {
            if (queen[i][j] == 'Q') {
                return false;
            }
        }

        for (int i=row+1, j=col-1; i<queen.length && j>=0; i++, j--) {
            if (queen[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void solveUntil(char[][] queen, int col) {

        if (col == queen.length) {
            count++;
            return;
        }

        for (int row=0; row<queen.length; row++) {
            if (isValid(queen, row, col)) {
                queen[row][col] = 'Q'; 
                solveUntil(queen, col + 1);
                queen[row][col] = '.';
            }
        }
    }
}