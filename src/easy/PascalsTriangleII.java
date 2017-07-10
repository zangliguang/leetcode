package easy;

/**
 * Created by zangliguang on 2017/7/10.Num113
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p>
 * For example, given k = 3,
 * Return [1,3,3,1].
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();

        if (rowIndex == 0) {
            list.add(1);
            return list;
        }
        if (rowIndex == 1) {
            list.add(1);
            list.add(1);
            return list;
        }

        List<Integer> lastRow = getRow(rowIndex - 1);
        list.add(1);
        for (int i = 0; i < lastRow.size() - 1; i++) {
            list.add(lastRow.get(i) + lastRow.get(i + 1));
        }
        list.add(1);
        System.out.println(list.toString());
        return list;

    }
}
