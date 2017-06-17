package easy;

/**
 * Created by zangliguang on 2017/6/17.Num257
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.right = root4;
        System.out.println(binaryTreePaths(root));

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (null == root || (root.left == null && root.right == null)) {
            return list;
        }

        List<NodePath> ln = getNodePathList(new NodePath(root, String.valueOf(root.val)));
        for (NodePath nodePath : ln) {
            list.add(nodePath.path);
        }
        return list;

    }

    private static List<NodePath> getNodePathList(NodePath np) {
        List<NodePath> list = new ArrayList<>();
        if (np.node.left == null && np.node.right == null) {
            list.add(np);
            return list;
        }

        if (np.node.left != null) {
            StringBuilder sb = new StringBuilder(np.path);
            sb.append("->");
            sb.append(np.node.left.val);
            NodePath nodePath = new NodePath(np.node.left, sb.toString());
            list.addAll(getNodePathList(nodePath));


        }
        if (np.node.right != null) {
            StringBuilder sb = new StringBuilder(np.path);
            sb.append("->");
            sb.append(np.node.right.val);
            NodePath nodePath = new NodePath(np.node.right, sb.toString());
            list.addAll(getNodePathList(nodePath));
        }

        return list;
    }


    public static class NodePath {
        public NodePath(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }

        TreeNode node;
        String path;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}