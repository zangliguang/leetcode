package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * <p>
 * <p>
 *          8
 *      8
 *   7    7
 * 2  4     8
 */
public class PseudoPalindromicPathsinaBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(6);
//        root.right.left.right = new TreeNode(2);
        System.out.println(pseudoPalindromicPaths(root));
    }


    public static int pseudoPalindromicPaths(TreeNode root) {
        return (int) canBePalindrome(root,new HashSet());
    }

    private static int canBePalindrome(TreeNode node, Set<Integer> numbers) {
        if(node==null) return 0;
        if(numbers.contains(node.val)){
            numbers.remove(node.val);
        }else{
            numbers.add(node.val);
        }
        if(node.left==node.right){
            return numbers.size()<=1?1:0;
        }
        int left=canBePalindrome(node.left,new HashSet(numbers));
        int right=canBePalindrome(node.right,new HashSet(numbers));
        return left+right;

    }

    private static boolean isPalindromic(int[] arr) {
        int index = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                index++;
            }
        }
        return index <= 1;
    }


    public static class TreeNode {
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
