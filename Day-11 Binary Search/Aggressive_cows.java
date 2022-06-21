import java.util.*;

public class Solution {
    public static boolean isPossible(ArrayList<Integer> stalls, int k, int mid) {
        int cowCount = 1;
        int lastPos = stalls.get(0);

        for (int i = 0; i < stalls.size(); i++) {
            if (stalls.get(i) - lastPos >= mid) {
                cowCount++;
                if (cowCount == k) {
                    return true;
                }
                lastPos = stalls.get(i);
            }
        }
        return false;
    }

    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
        Collections.sort(stalls);
        int s = 0, maxi = -1;
        for (int i = 0; i < stalls.size(); i++) {
            maxi = Math.max(maxi, stalls.get(i));
        }
        int e = maxi;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (isPossible(stalls, k, mid)) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
}