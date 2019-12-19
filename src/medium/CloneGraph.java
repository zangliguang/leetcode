package medium;

import java.util.*;

/**
 * 133. Clone Graph
 * <p>
 * Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.
 * <p>
 * <p>
 * OJ's undirected graph serialization (so you can understand error output):
 * Nodes are labeled uniquely.
 * <p>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * <p>
 * <p>
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * <p>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * <p>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * <p>
 * <p>
 * Visually, the graph looks like the following:
 * <p>
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 * Note: The information about the tree serialization is only meant so that you can understand error output if you get a wrong answer. You don't need to understand the serialization to solve the problem.
 * <p>
 * Accepted
 * 194,065
 * Submissions
 * 772,058
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> map = new HashMap(); //store visited nodes

        map.put(newNode.label, newNode); //add first node to HashMap

        LinkedList<UndirectedGraphNode> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue
        while (!queue.isEmpty()) { //if more nodes need to be visited
            UndirectedGraphNode n = queue.pop(); //search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label)); //add neighbor to new created nodes
            }
        }
        return newNode;

    }


    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
