package medium;

/**
 * 337. House Robber III
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * <p>
 * Input: [3,4,5,1,3,null,1]
 * <p>
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int max1 = rob(root.left) + rob(root.right);
        int leftMax = root.left != null ? rob(root.left.left) + rob(root.left.right) : 0;
        int rightMax = root.right != null ? rob(root.right.left) + rob(root.right.right) : 0;
        max1 = Math.max(max1, root.val + leftMax + rightMax);

        return max1;

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
