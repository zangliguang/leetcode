package medium;

import java.util.Arrays;

/**
 * 1008. Construct Binary Search Tree from Preorder Traversal
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 */
public class ConstruBinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder.length == 0) {
            return null;
        }


        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            root.left = null;
            root.right = null;

        } else {
            if (preorder[1] > root.val) {
                root.right = bstFromPreorder(Arrays.copyOfRange(preorder, 1, preorder.length));

                root.left = null;
            } else {
                for (int i = 1; i < preorder.length; i++) {

                    if (preorder[i] > root.val) {

                        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i));
                        root.right = bstFromPreorder(Arrays.copyOfRange(preorder, i, preorder.length));
                        return root;
                    }
                }
                root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1,  preorder.length));
                root.right =null;

            }
        }


        return root;


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
