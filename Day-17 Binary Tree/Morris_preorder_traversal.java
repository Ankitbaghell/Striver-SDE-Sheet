import java.util.*;

public class Solution {
    public static List<Integer> morrisPreOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root, pred;
        while (current != null) {
            ans.add(current.data);
            if (current.left == null) {
                current = current.right;
            } else {
                pred = current.left;
                while (pred.right != null && pred.right != current.right)
                    pred = pred.right;
                if (pred.right == null) {
                    pred.right = current.right;
                    current = current.left;
                } else {
                    pred.right = null;
                    current = current.right;
                }
            }
        }
        return ans;
    }
}