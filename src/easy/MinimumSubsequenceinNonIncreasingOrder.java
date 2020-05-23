package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. Minimum Subsequence in Non-Increasing Order
 */
public class MinimumSubsequenceinNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int total = 0;
        int total2 = 0;
        for (int num : nums) {
            total += num;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            total2 += nums[i];
            if (total2 * 2 > total) {
                return result;
            }
        }
        return result;
    }
}
