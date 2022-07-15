
import java.util.*;

public class Solution {
    public static List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root, pred;
        while (current != null) {
            if (current.left == null) {
                ans.add(current.data);
                current = current.right;
            } else {
                pred = current.left;
                while (pred.right != null && pred.right != current)
                    pred = pred.right;
                if (pred.right == null) {
                    pred.right = current;
                    current = current.left;
                } else {
                    pred.right = null;
                    ans.add(current.data);
                    current = current.right;
                }
            }
        }
        return ans;
    }
}