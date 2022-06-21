import java.util.ArrayList;

public class Solution {
    public static boolean isPossible(ArrayList<Integer> arr, int mid, int n, int k) {
        int painterCount = 1;
        int totalTime = 0;

        for (int i = 0; i < n; i++) {
            if (totalTime + arr.get(i) <= mid) {
                totalTime += arr.get(i);
            } else {
                painterCount++;
                if (painterCount > k || arr.get(i) > mid)
                    return false;
                totalTime = arr.get(i);
            }
        }
        return true;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int s = 0;
        int sum = 0;
        int n = boards.size();
        for (int i = 0; i < n; i++) {
            sum = sum + boards.get(i);
        }
        int e = sum;
        int ans = -1;
        int mid = (s + e) / 2;

        while (s <= e) {
            if (isPossible(boards, mid, n, k)) {
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