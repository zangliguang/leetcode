package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList();
        Stack<TreeNode> nodeStack = new Stack();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            TreeNode pop = nodeStack.pop();
            if (pop != null) {
                result.add(pop.val);
                nodeStack.push(pop.right);
                nodeStack.push(pop.left);
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
