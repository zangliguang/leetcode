package easy;

import java.util.Arrays;

/**
 * Created by zangliguang on 2017/7/8.Num108
 */
public class ConvertSortedArraytoBinarySearchTree {


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = getTreeNode(nums, 0, nums.length - 1);


        return root;

    }

    private TreeNode getTreeNode(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }
        int middle = start + (end - start) / 2;


        TreeNode root = new TreeNode(nums[middle]);


        root.left = getTreeNode(nums, start, middle - 1);
        root.right = getTreeNode(nums, middle + 1, end);
        return root;
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
