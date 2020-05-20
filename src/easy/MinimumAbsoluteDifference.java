package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * <p>
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * <p>
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 * <p>
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 * <p>
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
public class MinimumAbsoluteDifference {


    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i] - arr[i - 1];

            if (temp <= min) {
                int finalI = i;

                if (temp < min) {
                    result.clear();
                    min = temp;
                }


                result.add(new ArrayList<Integer>() {
                    {
                        add(arr[finalI - 1]);
                        add(arr[finalI]);
                    }


                });
            }


        }
        return result;

    }
}
