package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> pre = new ArrayList<>();
        if (numRows == 0) {
            return result;
        } else {
            pre.add(1);
            result.add(pre);
        }
        numRows--;
        for (int i = 1; i <= numRows; i++) {
            pre = (ArrayList<Integer>) result.get(result.size() - 1);
            ArrayList<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                current.add(pre.get(j) + pre.get(j + 1));
            }
            current.add(1);
            result.add(current);
        }

        return result;
    }
}
