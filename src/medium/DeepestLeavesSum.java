package medium;

import java.util.ArrayList;

/**
 * 1302. Deepest Leaves Sum
 * Given a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {

    }


    public int deepestLeavesSum(TreeNode root) {

        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        return setNodeList(list);


    }

    private int setNodeList(ArrayList<TreeNode> list) {
        int value = 0;
        ArrayList<TreeNode> subList = new ArrayList<TreeNode>();
        for (TreeNode node : list) {
            value += node.val;
            if (node.left != null) {
                subList.add(node.left);
            }
            if (node.right != null) {
                subList.add(node.right);
            }
        }
        if (subList.isEmpty()) {
            return value;
        }else{
            return setNodeList(subList);
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
