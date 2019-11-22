package medium;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 *
 *    2
 *   1  4
 *     3
 */
public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {

        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(right);
        if (left == null) {
            return;
        }
        flatten(left);
        TreeNode leftTail = left;
        while (null != leftTail.right) {
            leftTail = leftTail.right;
        }
        leftTail.right = right;
        root.right = left;
        root.left=null;


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
