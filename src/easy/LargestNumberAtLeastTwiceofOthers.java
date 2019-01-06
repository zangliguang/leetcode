package easy;

import java.util.Arrays;

/**
 * 747. Largest Number At Least Twice of Others
 * In a given integer array nums, there is always exactly one largest element.
 * <p>
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * <p>
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 */
public class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 0};
        System.out.println(dominantIndex(nums));

    }

    public static int dominantIndex2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int maxNum = temp[temp.length - 1];
        if (maxNum >= 2 * temp[temp.length - 2]) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == maxNum) {
                    return i;
                }
            }
        }
        return -1;


    }
    public static int dominantIndex(int[] nums) {
        int max = 0, secondMax = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return secondMax * 2 <= max ? index : -1;

    }
}
