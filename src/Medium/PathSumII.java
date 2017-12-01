package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * num113
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * return
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentResult = new ArrayList<Integer>();
        int count = 0;
        setList(root, currentResult, result, sum, count);


        return result;
    }

    private void setList(TreeNode root, ArrayList<Integer> currentResult, List<List<Integer>> result, int sum, int count) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (root.left == null && root.right == null) {
            if (sum == count + val) {
                currentResult.add(val);
                result.add(currentResult);
            }

        } else if (null != root.left && null != root.right) {
            currentResult.add(val);
            setList(root.left, (ArrayList<Integer>) currentResult.clone(), result, sum, count + val);
            setList(root.right, currentResult, result, sum, count + val);
        } else {
            currentResult.add(val);
            setList(root.left == null ? root.right : root.left, currentResult, result, sum, count + val);
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
