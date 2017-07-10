package easy;

/**
 * Created by zangliguang on 2017/7/10. Num572
 */

import java.util.ArrayList;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * <p>
 * Given tree t:
 * <p>
 * 4
 * / \
 * 1   2
 * <p>
 * Return true, because t has the same structure and node values with a subtree of s.
 * <p>
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * <p>
 * Given tree t:
 * <p>
 * 4
 * / \
 * 1   2
 */
public class SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return t == null;
        }
        if (isEqual(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }


    }


    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        if (t == null) {
            return s == null;
        }
        if (s.val != t.val) {
            return false;
        }

        if (t.right == null && t.left == null && s.right == null && s.left == null) {
            return true;
        }

        return isEqual(t.left, s.left) && isEqual(t.right, s.right);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
