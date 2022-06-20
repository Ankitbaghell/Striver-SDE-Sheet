import java.util.ArrayList;

public class Solution {
    static int countNoLessThanEqualToMid(ArrayList<Integer> mat, int mid) {
        int s = 0, e = mat.size() - 1;
        while (s <= e) {
            int middle = (s + e) / 2;
            if (mat.get(middle) <= mid)
                s = middle + 1;
            else
                e = middle - 1;
        }
        return s;
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int low = 1;
        int high = (int) 1e5;
        int row = matrix.size();
        int col = matrix.get(0).size();

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0; // number of elements <= mid
            for (int i = 0; i < row; i++) {
                count += countNoLessThanEqualToMid(matrix.get(i), mid);
            }

            if (count <= (row * col) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}