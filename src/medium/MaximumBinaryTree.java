package medium;

/**
 * Created by zangliguang on 2017/8/16.Num654
 */

import java.util.*;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * <p>
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * <p>
 * Note:
 * <p>
 * The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree(nums);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            list.add(nums[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);

        TreeNode treeNode = createNode(list, map, 0, nums.length - 1);

        return treeNode;

    }

    private static TreeNode createNode(ArrayList<Integer> list, HashMap<Integer, Integer> map, int start, int end) {
        if (list.isEmpty() || start > end) {
            return null;
        }
        TreeNode treeNode = null;
        int originIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            Integer val = list.get(i);
            originIndex = map.get(val);
            if (originIndex >= start && originIndex <= end) {
                treeNode = new TreeNode(val);
                list.remove(i);
                map.remove(val);
                break;
            }
        }
        treeNode.left = createNode(list, map, start, originIndex - 1);
        treeNode.right = createNode(list, map, originIndex + 1, end);

        System.out.printf("值：" + treeNode.val);
        return treeNode;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
