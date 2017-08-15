package easy;

/**
 * Created by zangliguang on 2017/8/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */

/*

        236
104            701
    277              911
 */

public class MinimumAbsoluteDifferenceinBST {

    int minDiff = Integer.MAX_VALUE;
    TreeNode preNode;

    public int getMinimumDifference(TreeNode root) {
        setList(root);
        return minDiff;

    }

    private void setList(TreeNode root) {
        if (root == null) {
            return;
        }
        setList(root.left);
        if (preNode != null) {
            minDiff = Math.min(minDiff, root.val - preNode.val);
        }
        preNode = root;
        setList(root.right);
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
