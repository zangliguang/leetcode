package easy;

/**
 * Created by zangliguang on 2017/6/30.Num496
 */

import java.util.Arrays;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Note:
 * <p>
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */
public class NextGreaterElementI {
    public static void main(String[] args) {

        int[] findNums = new int[]{1, 3, 5, 2, 4};
        int[] nums = new int[]{5, 4, 3, 2, 1};
        int[] result = nextGreaterElement(findNums, nums);
        System.out.println(Arrays.toString(result));

    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Arrays.fill(result, -1);
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < findNums.length; i++) {
            if (i >= nums.length) {
                continue;
            }
            boolean find = false;
            for (int j = 0; j < nums.length; j++) {

                if (nums[j] == findNums[i]) {
                    find = true;
                    continue;

                }
                if (find && nums[j] > findNums[i]) {
                    result[i] = nums[j];
                    find = false;
                    break;
                }
            }
        }
        return result;

    }
}
