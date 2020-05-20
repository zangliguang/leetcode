package medium;

/**
 * 1379 Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class FindaCorrespondingNodeofaBinaryTreeinaCloneofThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null || original == target)
            return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null)
            return res;
        return getTargetCopy(original.right, cloned.right, target);


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
