package medium;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {

    }

    public static Node connect(Node root) {

        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        List<Node> currentlist = new ArrayList<>();
        currentlist.add(root);
        List<Node> sonList = new ArrayList<>();
        while (!currentlist.isEmpty()) {

            for (Node node : currentlist) {
                if (null != node.left) {
                    sonList.add(node.left);
                }
                if (null != node.right) {

                    sonList.add(node.right);
                }
            }
            if (sonList.isEmpty()) {
                break;
            }
            for (int i = 0; i < sonList.size() - 1; i++) {
                sonList.get(i).next = sonList.get(i + 1);
            }
            currentlist.clear();
            currentlist.addAll(sonList);
            sonList.clear();
        }
        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}