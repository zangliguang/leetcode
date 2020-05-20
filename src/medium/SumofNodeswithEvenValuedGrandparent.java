package medium;

import java.util.ArrayList;

/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
 * <p>
 * If there are no nodes with an even-valued grandparent, return 0.
 */
public class SumofNodeswithEvenValuedGrandparent {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        int result = 0;
        if(root==null){
            return 0;
        }

        if(root.val%2==0){
               result+=sumOfGrandson(root);
        }
            result+= sumEvenGrandparent(root.left);
            result+= sumEvenGrandparent(root.right);



        return  result;
    }

    private int sumOfGrandson(TreeNode root) {
        if(root==null){
            return 0;
        }
        int val=0;
        if(root.left!=null){
            if(root.left.left!=null){
                val+=root.left.left.val;
            }
            if(root.left.right!=null){
                val+=root.left.right.val;
            }
        }
        if(root.right!=null){
            if(root.right.left!=null){
                val+=root.right.left.val;
            }
            if(root.right.right!=null){
                val+=root.right.right.val;
            }
        }
        return val;
    }
}
