package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Num515
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (null != root) {
            list.add(root);
        }
        setRes(res, list);


        return res;

    }

    private void setRes(List<Integer> res, List<TreeNode> originList) {

        if (originList.isEmpty()) {
            return;
        }
        int max = Integer.MIN_VALUE;
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode treeNode : originList) {
            max = Math.max(max, treeNode.val);
            if (null != treeNode.left) {
                list.add(treeNode.left);
            }
            if (null != treeNode.right) {
                list.add(treeNode.right);
            }

        }
        res.add(max);
        setRes(res, list);

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
