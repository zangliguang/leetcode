package easy;

/**
 * Created by zangliguang on 2017/8/8.Num653
 */

import java.util.HashMap;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();


        return setMap(root, k, map);
    }

    private boolean setMap(TreeNode root, int k, HashMap<Integer, Integer> map) {
        if (null != root.left && setMap(root.left, k, map)) {
            return true;
        }

        if (null != map.getOrDefault((k - root.val), null)) {
            return true;
        }
        map.put(root.val, k - root.val);
        if (null != root.right) {
            return setMap(root.right, k, map);
        }
        return false;
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
