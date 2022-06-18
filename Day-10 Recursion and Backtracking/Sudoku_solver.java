
class Solution {

    boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) // row already have same character
                return false;

            if (board[i][col] == ch) // col already have same character
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) // 3*3 box already have same character
                return false;
        }
        return true;
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) { // traversing over the board
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') { // empty space
                    for (char ch = '1'; ch <= '9'; ch++) { // trying to put all numbers
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solve(board) == true) { // beacuse i get my answer
                                return true;
                            } else
                                board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // not able to put any number return false
                }
            }
        }
        return true; // Complete scanning and no empty space return true
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}