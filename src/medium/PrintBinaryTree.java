package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * num655
 * <p>
 * Print a binary tree in an m*n 2D string array following these rules:
 * <p>
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * <p>
 * Input:
 * 1
 * /
 * 2
 * Output:
 * [["", "1", ""],
 * ["2", "", ""]]
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * Output:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * <p>
 * Example 3:
 * <p>
 * Input:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * Output:
 * <p>
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 */
public class PrintBinaryTree {


    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();

        int height = getHeight(root);
        int listSize = (int) (Math.pow(2, height) - 1);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add("");
        }

        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        ArrayList<String> first = (ArrayList<String>) list.clone();
        first.set(listSize / 2, String.valueOf(root.val));
        result.add(first);
        for (int i = 0; i < height - 1; i++) {
            ArrayList<String> newList = (ArrayList<String>) list.clone();
            newList.set((int) (listSize / (Math.pow(2, i + 1))), String.valueOf(nodeList.get(i).val));
            result.add(newList);
        }
        return result;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
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
