package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> current = new ArrayList<>();
        current.add(root);

        List<TreeNode> next = new ArrayList<>();
        while (!current.isEmpty()) {
            for (int i = 0; i < current.size(); i++) {
                if (null != current.get(i).left) {
                    next.add(current.get(i).left);
                }
                if (null != current.get(i).right) {
                    next.add(current.get(i).right);
                }


            }
            result.add(current.get(current.size() - 1).val);
            current.clear();
            current.addAll(next);
            next.clear();

        }
        return result;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
