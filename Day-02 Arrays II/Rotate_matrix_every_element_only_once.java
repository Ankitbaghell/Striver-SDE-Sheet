
import java.util.ArrayList;

// logic is same as of SPIRAL MATRIX
class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int startRow = 0;
        int startCol = 0;
        int lastRow = n - 1;
        int lastCol = m - 1;

        int prev, curr;

        while (startRow < lastRow && startCol < lastCol) {
            // if(startRow == lastRow || startCol == lastCol)
            // break;

            prev = mat.get(startRow + 1).get(startCol);

            for (int i = startCol; i <= lastCol; i++) {
                curr = mat.get(startRow).get(i);
                mat.get(startRow).set(i, prev);
                prev = curr;
            }
            startRow++;

            for (int j = startRow; j <= lastRow; j++) {
                curr = mat.get(j).get(lastCol);
                mat.get(j).set(lastCol, prev);
                prev = curr;
            }
            lastCol--;

            if (startRow <= lastRow) {
                for (int i = lastCol; i >= startCol; i--) {
                    curr = mat.get(lastRow).get(i);
                    mat.get(lastRow).set(i, prev);
                    prev = curr;
                }
                lastRow--;
            }

            if (startCol <= lastCol) {
                for (int j = lastRow; j >= startRow; j--) {
                    curr = mat.get(j).get(startCol);
                    mat.get(j).set(startCol, prev);
                    prev = curr;
                }
                startCol++;
            }
        }

    }
}
