package easy;

import java.util.Arrays;

/**
 * num189
 * <p>
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Related problem: Reverse Words in a String II
 * <p>
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        rotate(nums, 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);

    }


    public static void reverse(int[] nums, int l, int r) {
        while (r > l) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            r--;
            l++;
        }


    }
}
