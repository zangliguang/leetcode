package medium;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(0,0,inorder.length-1,preorder,inorder);

    }

    private TreeNode build(int preStart, int inStart,int inEnd, int[] preorder, int[] inorder) {
        TreeNode root =new TreeNode(preorder[preStart]);

        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = build(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = build(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }


}
