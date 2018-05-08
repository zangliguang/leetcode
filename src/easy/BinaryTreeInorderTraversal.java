package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree [1,null,2,3],
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,3,2].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        addToStack(root, stack);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            addToStack(pop.right, stack);
        }
        return result;

    }

    private void addToStack(TreeNode root, Stack<TreeNode> stack) {
        if (null == root) {
            return;
        }
        stack.add(root);
        TreeNode temp = root.left;
        while (null != temp) {
            stack.add(temp);
            temp = temp.left;
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
