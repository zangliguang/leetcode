package easy;

/**
 * 671 Second Minimum Node In a Binary Tree
 * [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
 * 1,
 * 1,        3,
 * 1,    1,   3,   4,
 * 3,   1, 1, 1,3,8, 4, 8,
 * 3,  3,1,6,2,1
 */
public class SecondMinimumNodeInaBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        int result = -1;
        if (root.left == root.right) {
            return result;
        }
        if (root.val != root.left.val) {
            result = Math.min(findSecondMinimumValue(root.right), root.left.val);
            return result == -1 ? root.left.val : result;
        }
        if (root.val != root.right.val) {
            result = Math.min(findSecondMinimumValue(root.left), root.right.val);
            return result == -1 ? root.right.val : result;
        }
        int right = findSecondMinimumValue(root.right);
        int left = findSecondMinimumValue(root.left);
        if (left == -1 && right == -1) {
            return -1;
        }
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
