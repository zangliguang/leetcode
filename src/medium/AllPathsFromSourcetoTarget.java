package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * <p>
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * <p>
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * <p>
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 * <p>
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourcetoTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph == null) {
            return result;
        }


        backtrack(result, new ArrayList<>(), 0, graph.length - 1, graph);
        return result;


    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> list, int start, int end, int[][] graph) {
        if (start == end) {
            list.add(start);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int next : graph[start]) {
            list.add(start);
            backtrack(result, list, next, end, graph);
            list.remove(list.size() - 1);
        }
    }
}
