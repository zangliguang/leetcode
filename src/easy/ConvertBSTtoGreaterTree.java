package easy;

/**
 * Created by zangliguang on 2017/7/31. Num538
 */

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 */
public class ConvertBSTtoGreaterTree {


    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
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
