
import java.util.*;

public class Solution {
    static void solve(TreeNode<Integer> root, int level, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.data);
        solve(root.left, level + 1, ans);
        solve(root.right, level + 1, ans);
    }

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, 0, ans);
        return ans;
    }
}
