package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 */
public class NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        for (Node child : root.children) {
            result.addAll(preorder(child));
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
