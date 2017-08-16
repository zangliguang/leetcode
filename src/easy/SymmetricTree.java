package easy;

/**
 * Num101
 */
public class SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isMirror(root.left, root.right);


    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isMirror(left.right, right.left) && isMirror(left.left, right.right);
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
