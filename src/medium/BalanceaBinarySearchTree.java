package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 */
public class BalanceaBinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {

        List<TreeNode> lst=ergodic(root);

        int start =0,end=lst.size()-1;
        TreeNode result = reorder(lst, start, end);

        return result;
    }

    private TreeNode reorder(List<TreeNode> lst, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode res = lst.get(mid);
        res.left=reorder(lst,start,mid-1);
        res.right=reorder(lst,mid+1,end);
        return res;
    }

    private List<TreeNode> ergodic(TreeNode root) {
        if(root==null){
            return  new ArrayList<>();
        }
        TreeNode left=root.left;
        List<TreeNode> sortedArr =ergodic(left);
        sortedArr.add(root);
        sortedArr.addAll(ergodic(root.right));
        root.left = null;
        root.right = null;
        return sortedArr;
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
