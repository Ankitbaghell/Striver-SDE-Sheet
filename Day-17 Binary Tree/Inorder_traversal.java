// iterative
public class Solution {
    public static List<Integer> getInOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                if (st.empty())
                    break;
                root = st.pop();
                ans.add(root.data);
                root = root.right;
            }
        }
        return ans;
    }
}

// Recusrive
class Solution {
    public void solve(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        solve(root.left, ans);
        ans.add(root.val);
        solve(root.right, ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, ans);
        return ans;
    }
}
