package easy;

/**
 * Created by zangliguang on 2017/6/28.Num581
 */

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * <p>
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] num = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(num));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0;
        while (start < nums.length && nums[start] == temp[start]) start++;

        int end = nums.length - 1;
        while (end > start && nums[end] == temp[end]) end--;

        return end - start + 1;
    }
}
