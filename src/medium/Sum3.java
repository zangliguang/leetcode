package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                setResult(result, nums, i);
            }
        }
        return result;
    }

    private void setResult(List<List<Integer>> result, int[] nums, int index) {
        if (index > 0 && nums[index] == nums[index - 1]) {
            return;
        }

        int total = -nums[index];
        int length = nums.length;
        int start = index + 1;
        for (int i = start; i < length; i++) {
            if (i > start && nums[start] == nums[start - 1]) {
                continue;
            }
            int lastIndex = Arrays.binarySearch(nums, i + 1, length, total - nums[i]);
            if (lastIndex > 1) {
                result.add(Arrays.asList(nums[index],nums[i],nums[lastIndex]));
            }
        }
    }
}

