package medium;

import easy.BinaryTreePaths;

/**
 * 96. Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if(n==0||n==1)
            return 1;
        int[] F = new int[n+1];//注意长度
        F[0]=1;
        F[1]=1;//注意初始化
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                F[i] += F[j-1]*F[i-j];
            }
        }
        return F[n];
    }


    public static class TreeNode {
        int val;
        BinaryTreePaths.TreeNode left;
        BinaryTreePaths.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
