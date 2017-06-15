package easy;

/**
 * Created by zangliguang on 2017/6/13.Num617
 */

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        //617

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode res = null;
        if (null != t1 && null != t2) {
            res = new TreeNode(t1.val + t2.val);
            res.left = mergeTrees(t1.left, t2.left);
            res.right = mergeTrees(t1.right, t2.right);
        } else if (null != t1) {
            res = t1;
        } else if (null != t2) {
            res = t2;
        } else {
            return null;
        }

        return res;

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
