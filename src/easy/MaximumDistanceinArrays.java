package easy;

/**
 * Created by zangliguang on 2017/6/28.
 */

import java.util.List;

/**
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * <p>
 * Note:
 * <p>
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000].
 */
public class MaximumDistanceinArrays {


    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> integers = arrays.get(i);

            result = Math.max(result, Math.abs(integers.get(0) - max));
            result = Math.max(result, Math.abs(integers.get(integers.size() - 1) - min));

            max = Math.max(max, integers.get(integers.size() - 1));
            min = Math.min(min, integers.get(0));
        }
        return result;

    }


}
