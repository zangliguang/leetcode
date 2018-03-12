package medium;

import java.util.ArrayList;

/**
 * num513
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * <p>
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        setList(list);
        return list.get(0).val;

    }

    public void setList(ArrayList<TreeNode> originList) {
        ArrayList<TreeNode> list = new ArrayList<>();
        for (TreeNode treeNode : originList) {
            if (treeNode.left != null) {
                list.add(treeNode.left);
            }
            if (treeNode.right != null) {
                list.add(treeNode.right);
            }
        }
        if (list.size() != 0) {
            originList.clear();
            originList.addAll(list);
            setList(originList);
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
