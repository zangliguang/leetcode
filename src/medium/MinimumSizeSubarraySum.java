package medium;

/**
 * 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }



}
