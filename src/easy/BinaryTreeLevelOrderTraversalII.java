package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> treeNodes = new ArrayList();
        treeNodes.add(root);
        setResult(result, treeNodes);
        Collections.reverse(result);
        return result;
    }

    private void setResult(List<List<Integer>> result, List<TreeNode> treeNodes) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> treelist = new ArrayList<>();
        for (TreeNode treeNode : treeNodes) {
            list.add(treeNode.val);
            if (null != treeNode.left) {
                treelist.add(treeNode.left);
            }
            if (null != treeNode.right) {
                treelist.add(treeNode.right);
            }
        }
        if (!list.isEmpty()) {
            result.add(list);
            setResult(result, treelist);
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
