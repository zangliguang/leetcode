package easy;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 993 Cousins in Binary Tree
 */
public class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<TreeNode> temp = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        list.add(root);
        while (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {

                TreeNode current = list.get(i);
                if (current.left != null & current.right != null) {
                    if (current.left.val == x && current.right.val == y) {
                        return false;
                    }
                    if (current.left.val == y && current.right.val == x) {
                        return false;
                    }
                }

                if (null != current.left) {
                    temp.add(current.left);
                    set.add(current.left.val);
                }
                if (null != current.right) {
                    temp.add(current.right);
                    set.add(current.right.val);
                }


            }
            if (set.contains(x) && set.contains(y)) {
                return true;
            }
            list.clear();
            list.addAll(temp);
            temp.clear();
            set.clear();

        }
        return false;


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
