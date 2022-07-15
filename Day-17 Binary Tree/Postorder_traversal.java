//iterative

import java.util.*;

public class Solution {
    public static List<Integer> getPostOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if (root == null)
            return ans;
        st1.push(root);
        while (!st1.empty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null)
                st1.push(root.left);
            if (root.right != null)
                st1.push(root.right);
        }

        while (!st2.empty()) {
            ans.add(st2.pop().data);
        }
        return ans;
    }
}

// recursive
class Solution {
    public void solve(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        solve(root.left, ans);
        solve(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }
}