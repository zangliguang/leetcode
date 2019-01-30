package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * Return its postorder traversal as: [5,6,3,2,4,1].
 */
public class NAryTreePostorderTraversal {

    public List<Integer> postorder(Node root) {


        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        for (Node child : root.children) {
            result.addAll(postorder(child));
        }
        result.add(root.val);
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
