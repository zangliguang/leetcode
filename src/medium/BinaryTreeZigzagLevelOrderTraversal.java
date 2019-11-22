package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * num103
 * <p>
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    boolean flag = false;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return result;
        }

        List<TreeNode> nodeList = new ArrayList<>();

        nodeList.add(root);

        while (!nodeList.isEmpty()) {
            nodeList = setNodes(nodeList, flag);
            flag = !flag;
        }


        return result;

    }

    private List<TreeNode> setNodes(List<TreeNode> nodeList, boolean flag) {
        List<TreeNode> nodeList2 = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        for (TreeNode treeNode : nodeList) {

            item.add(treeNode.val);

            if (null != treeNode.left) {

                nodeList2.add(treeNode.left);
            }
            if (null != treeNode.right) {
                nodeList2.add(treeNode.right);
            }

        }
        if (!flag) {
            Collections.reverse(item);
        }
        result.add(item);
        return nodeList2;
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
