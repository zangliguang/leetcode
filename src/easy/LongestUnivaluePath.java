package easy;

/**
 * 687. Longest Univalue Path
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 */
public class LongestUnivaluePath {

    int length = 0;




    public int longestUnivaluePath(TreeNode root) {

        if (root == null) return 0;
        length = 0;
        longestPath(root, root.val);
        return length;


    }

    private int longestPath(TreeNode root, int val) {
        if (root == null) return 0;
        int left = longestPath(root.left, root.val);
        int right = longestPath(root.right, root.val);
        length = Math.max(length, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;


    }




    public int longestUnivaluePath2(TreeNode root) {
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0; // Longest-Univalue-Path-Start-At - left child
        int r = node.right != null ? dfs(node.right, res) : 0; // Longest-Univalue-Path-Start-At - right child
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; // Longest-Univalue-Path-Start-At - node, and go left
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; // Longest-Univalue-Path-Start-At - node, and go right
        res[0] = Math.max(res[0], resl + resr); // Longest-Univalue-Path-Across - node
        return Math.max(resl, resr);
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
