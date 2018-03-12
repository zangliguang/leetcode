package medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 413. Arithmetic Slices
 * <p>
 * <p>
 * <p>
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * <p>
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class ArithmeticSlices {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.printf("结果:" + numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int result = 0;
        Integer diff = nums[1] - nums[0];
        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (diff == nums[i + 1] - nums[i]) {
                num++;
            } else {
                if (num > 1) {
                    list.add(num);
                }
                diff = nums[i + 1] - nums[i];
                num = 1;
            }
        }
        if (num > 1) {
            list.add(num);
        }
        System.out.printf("num:" + Arrays.toString(list.toArray()));
        for (Integer integer : list) {
            result += getNums(integer);
        }
        return result;

    }

    private static int getNums(Integer num) {
        int result = 0;
        for (Integer integer = 1; integer < num; integer++) {
            result += (num - integer);
        }
        return result;
    }

}
