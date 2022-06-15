import java.util.*;

public class Solution {
    static void solve(int num[], int index, int sum, ArrayList<Integer> ans) {
        if (index >= num.length) {
            ans.add(sum);
            return;
        }

        solve(num, index + 1, sum, ans);
        solve(num, index + 1, sum + num[index], ans);
    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(num, 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }

}