package medium;

import java.util.Arrays;

/**
 * num34
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        int i = Arrays.binarySearch(nums, target);
        if (i != -1) {
            start = i;
            end = i;
            while (start > 0 && nums[start] == nums[start - 1]) {
                start--;
            }
            while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                end++;
            }
        }

        return new int[]{start, end};

    }
}
