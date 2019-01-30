package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * <p>
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<TreeNode> list1 = getTreeLeafNodes(root1);
        List<TreeNode> list2 = getTreeLeafNodes(root2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).val != list2.get(i).val) {
                return false;
            }
        }
        return true;

    }

    private List<TreeNode> getTreeLeafNodes(TreeNode root1) {
        List<TreeNode> list = new ArrayList();
        if (root1 == null) {
            return list;
        }
        if (root1.left == null && root1.right == null) {
            list.add(root1);
            return list;
        }
        list.addAll(getTreeLeafNodes(root1.left));
        list.addAll(getTreeLeafNodes(root1.right));
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
