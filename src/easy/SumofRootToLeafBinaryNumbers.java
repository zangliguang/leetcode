package easy;

/**
 * 1022 Sum of Root To Leaf Binary Numbers
 */
public class SumofRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {

        return calculation(0,root);

    }

    private int calculation(int lastValue, TreeNode root) {
        if(root==null){
            return 0;
        }

        lastValue=lastValue*2+root.val;
        return  root.left == root.right ? lastValue:calculation(lastValue,root.left)+calculation(lastValue,root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
