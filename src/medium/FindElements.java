package medium;

import java.util.HashSet;

/**
 * num 1261 Find Elements in a Contaminated Binary Tree
 */
public class FindElements {
    TreeNode root;
    HashSet<Integer>set = new HashSet<>();

    public FindElements(TreeNode root) {
        this.root = root;
        root.val=0;
        setValue(root);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
    private void setValue(TreeNode root) {
        set.add(root.val);
        if (null != root.left) {
            root.left.val = root.val * 2 + 1;
            setValue(root.left);
        }

        if (null != root.right) {
            root.right.val = root.val * 2 + 2;
            setValue(root.right);
        }
    }

//    public FindElements(TreeNode root) {
//        this.root = root;
//    }
//
//    public boolean find(int target) {
//        if(root==null){
//            return false;
//        }
//        if(root.val==-1){
//            root.val=0;
//        }
//
//        if(root.val==target){
//            return true;
//        }else{
//            if(null!=root.left){
//                root.left.val=root.val*2+1;
//            }
//
//            if(null!=root.right){
//                root.right.val=root.val*2+2;
//            }
//            if(new FindElements(root.left).find(target)){
//                return true;
//            }
//
//            if(new FindElements(root.right).find(target)){
//                return true;
//            }
//        }
//
//        return false;
//    }


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
