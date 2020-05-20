package medium;

/**
 * 814. Binary Tree Pruning
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }

        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.val==0&&root.left==root.right){
            return null;
        }
        return root;
    }


    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
