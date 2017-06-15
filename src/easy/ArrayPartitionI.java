package easy;

/**
 * Created by zangliguang on 2017/6/13. Num561
 */

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * <p>
 * Note:
 * <p>
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class ArrayPartitionI {

    public static void main(String[] args) {

    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
