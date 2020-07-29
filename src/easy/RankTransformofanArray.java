package easy;

import java.sql.Array;
import java.util.*;

/**
 * 1331 Rank Transform of an Array
 */
public class RankTransformofanArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
    }

    public static int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] clone = arr.clone();
        Arrays.sort(clone);
        ArrayList<Integer> list = new ArrayList();
        list.add(clone[0]);
        for (int i = 1; i < clone.length; i++) {
            if (list.get(list.size() - 1) != clone[i]) {
                list.add(clone[i]);
            }

        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for (int i = 0; i < arr.length; i++) {
            clone[i] = map.get(arr[i]) + 1;
        }
        return clone;
    }
}
