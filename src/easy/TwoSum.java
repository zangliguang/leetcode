package easy;

import java.util.Arrays;


/**
 * Created by zangliguang on 2017/6/9.
 */


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


public class TwoSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3, 2, 4}, 6);

        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int head = 0; head <= nums.length - 2; head++) {
            for (int foot = head + 1; foot <= nums.length - 1; foot++) {
                if (nums[head] + nums[foot] == target) {
                    return new int[]{head, foot};
                }
            }

        }

        return null;
    }
}
