package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = preOrder(root, k);
        return list.get(k - 1).val;


    }

    public List<TreeNode> preOrder(TreeNode root, int k) {

        List<TreeNode> list = new ArrayList();
        if (root == null) {
            return list;
        }
        list.addAll(preOrder(root.left, k));
        if (list.size() == k) {
            return list;
        }

        list.add(root);
        if (list.size() == k) {
            return list;
        }
        list.addAll(preOrder(root.right, k));
        return list;

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
