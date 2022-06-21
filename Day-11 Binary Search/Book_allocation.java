import java.util.*;

public class Solution {

    public static boolean isPossible(ArrayList<Integer> A, int n, int B, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++) {
            if (pageSum + A.get(i) <= mid) {
                pageSum = pageSum + A.get(i);
            } else {
                studentCount++;
                if (studentCount > B || A.get(i) > mid)
                    return false;
                pageSum = A.get(i);
            }
        }
        return true;
    }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        int s = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr.get(i);
        }
        int e = sum;
        int ans = -1;
        int mid = (s + e) / 2;
        while (s <= e) {
            if (isPossible(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = (s + e) / 2;
        }
        return ans;
    }

}
