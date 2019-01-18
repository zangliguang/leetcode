package easy;

import java.util.Stack;

/**
 * 897. Increasing Order Search Tree
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * <p>
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 * <p>
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
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
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode result = null;
        TreeNode pointer = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        result = stack.pop();
        result.left = null;
        result.right = increasingBST(result.right);
        pointer = result;
        while (pointer.right != null) {
            pointer = pointer.right;
        }

        while (!stack.empty()) {
            pointer.right = stack.pop();
            pointer = pointer.right;
            pointer.left = null;
            pointer.right = increasingBST(pointer.right);
            while (pointer.right != null) {
                pointer = pointer.right;
            }
        }
        return result;

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
