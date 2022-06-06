
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean isRow = false, isCol = false; // to check is 0th row and col have their own zero
        for (int i = 0; i < col; i++) // 0-th row
            if (matrix[0][i] == 0)
                isRow = true;

        for (int j = 0; j < row; j++) // 0-th col
            if (matrix[j][0] == 0)
                isCol = true;

        // now using 0th row and 0th col as a marker to store which row and col have 0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // now traverse on 0th row and 0th col and make corresponding rows and cols zero
        // we have to leave the 00th index
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < row; j++)
                    matrix[j][i] = 0;
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j++)
                    matrix[i][j] = 0;
            }
        }

        // now update the 0th row and 0th col according to isRow and isCol marker
        if (isRow) { // it contains original zero in starting => make all zero
            for (int i = 0; i < col; i++)
                matrix[0][i] = 0;
        }

        if (isCol) { // it contains original zero in starting => make all zero
            for (int i = 0; i < row; i++)
                matrix[i][0] = 0;
        }
    }
}