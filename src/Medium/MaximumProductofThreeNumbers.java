package Medium;

/**
 * Created by zangliguang on 2017/7/5.NUm628
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: 6
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: 24
 * <p>
 * Note:
 * <p>
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);


    }
}
