package medium;

import java.util.ArrayList;

/**
 * 129 Sum Root to Leaf Numbers
 */
public class SumRoottoLeafNumbers {

    public int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }
    public int sum(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<TreeNode> temp = new ArrayList<>();
        ArrayList<TreeNode> resultList = new ArrayList<>();
        list.add(root);
        temp.add(root);
        while (!temp.isEmpty()) {
            temp.clear();
            for (TreeNode treeNode : list) {
                if (treeNode.right == treeNode.left) {
                    resultList.add(treeNode);
                }
                if (treeNode.left != null) {
                    treeNode.left.val += treeNode.val*10;
                    temp.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNode.right.val += treeNode.val*10;
                    temp.add(treeNode.right);
                }

            }
            list.clear();
            list.addAll(temp);
        }


        int result = 0;
        for (TreeNode treeNode : resultList) {
            result += treeNode.val;
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
