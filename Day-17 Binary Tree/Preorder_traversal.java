//iterative

import java.util.*;

public class Solution {
    public static List<Integer> getPreOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (true) {
            if (root != null) {
                ans.add(root.data);
                st.push(root);
                root = root.left;
            } else {
                if (st.empty())
                    break;
                root = st.pop();
                root = root.right;
            }
        }
        return ans;
    }
}

// recursive

class Solution {

    public void solve(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        solve(root.left, ans);
        solve(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }
}