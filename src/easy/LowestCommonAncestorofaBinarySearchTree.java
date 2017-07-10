package easy;

import java.util.Stack;

/**
 * Created by zangliguang on 2017/7/10.Num235
 */
public class LowestCommonAncestorofaBinarySearchTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) {
            return root;
        }

        if ((q.val > root.val && p.val < root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        TreeNode newRoot = (Math.max(q.val, p.val) < root.val) ? root.left : root.right;
        return lowestCommonAncestor(newRoot, p, q);


    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
