class Solution { // we are using reverse preorder traversal
    void solve(TreeNode root, List<Integer> ans, int level) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.val); // first node of level encountered
        solve(root.right, ans, level + 1);
        solve(root.left, ans, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        solve(root, ans, 0);
        return ans;
    }
}