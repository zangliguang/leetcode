package easy;

/**
 * Created by zangliguang on 2017/8/15.Num563
 */

/**
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * <p>
 * Note:
 * <p>
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */


/*
     1
  2      3
4      5
 */
public class BinaryTreeTilt {

    int result = 0;

    public int findTilt2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }


        getTilt(root);
        return result;
    }

    private int getTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getTilt(root.left);
        int right = getTilt(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {


        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        int result = 0;
        result += Math.abs(getTotal(root.left) - getTotal(root.right));
        result += findTilt(root.left);
        result += findTilt(root.right);

        return result;
    }

    private int getTotal(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getTotal(root.left) + root.val + getTotal(root.right);
        }
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
