package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal
 * <p>
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * We should return its level order traversal:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        List<List<Node>> nodeResult = new ArrayList();
        List<Node> list = new ArrayList();
        list.add(root);
        List<Integer> listValue = new ArrayList();
        listValue.add(root.val);
        result.add(listValue);
        nodeResult.add(list);
        while (true) {
            List<Node> nodes = nodeResult.get(nodeResult.size() - 1);
            if (nodes.size() == 0) {
                break;
            }
            List<Node> list2 = new ArrayList();
            for (Node node : nodes) {
                list2.addAll(node.children);
            }
            List<Integer> listValue2 = new ArrayList();
            for (Node node : list2) {
                listValue2.add(node.val);
            }
            if(!listValue2.isEmpty()){
                result.add(listValue2);
            }

            nodeResult.add(list2);

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
