package easy;

import java.util.ArrayList;

/**
 * 783 Minimum Distance Between BST Nodes
 */
public class MinimumDistanceBetweenBSTNodes {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(48);
        root.right.left=new TreeNode(12);
        root.right.right=new TreeNode(49);
        System.out.println(minDiffInBST(root));
    }

    public static int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        setList(root, list);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            result = Math.min(result, list.get(i) - list.get(i-1));
        }
        return result;
    }

    private static void setList(TreeNode root, ArrayList<Integer> list) {
        if (root.left != null) {
            setList(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            setList(root.right, list);
        }
    }

    public static class TreeNode {
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
