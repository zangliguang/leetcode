package medium;

import java.util.ArrayList;

/**
 * 222 Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes2(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }
    public int countNodes(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<TreeNode> temp = new ArrayList<>();


        int result = 0;
        if (null != root) {
            list.add(root);
        }
        while (!list.isEmpty()) {
            result += list.size();
            for (TreeNode treeNode : list) {
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                }
            }
            list.clear();
            list.addAll(temp);
            temp.clear();
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
