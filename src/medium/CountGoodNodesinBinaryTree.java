package medium;

/**
 * 1448. Count Good Nodes in Binary Tree
 */
public class CountGoodNodesinBinaryTree {
    public int goodNodes(TreeNode root) {


        return getResult(root, Integer.MIN_VALUE);





    }

    private int getResult(TreeNode root, int max) {
        if(root==null){
            return 0;
        }
        int result=0;
        if(root.val>= max){
            result +=1;
            max = root.val;
        }
        result+=getResult(root.left,max);
        result+=getResult(root.right,max);
        return result;
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
