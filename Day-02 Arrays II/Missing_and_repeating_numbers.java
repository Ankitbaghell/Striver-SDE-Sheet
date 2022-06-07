import java.util.*;

class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int R = -1, M, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.add(i) == false) {
                R = i;
                break;
            }
        }

        for (int i : arr)
            sum += i;

        sum -= R;

        M = n * (n + 1) / 2 - sum;

        return new int[] { M, R };

    }
}