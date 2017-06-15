package easy;

/**
 * Created by zangliguang on 2017/6/14.Num268
 */

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question.
 */

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int i;
        Arrays.sort(nums);
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return i;
    }

    public int missingNumber2(int[] nums) {
        int total = (nums.length * (nums.length + 1)) / 2;

        for (int i = 0; i < nums.length; i++) {
            total -= nums[i];
        }
        return total;
    }
}
