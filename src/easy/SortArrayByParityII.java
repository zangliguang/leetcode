package easy;

import java.util.Arrays;

/**
 * num 922
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * <p>
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,2,3,0,4};
        System.out.println(Arrays.toString(sortArrayByParityII(array)));
    }
    public static int[] sortArrayByParityII(int[] A) {
        int halfLength = A.length ;
        int even = 0, odd = 1;
        int head = -1, tail = -1;
        while (odd <= halfLength-1 && even <= halfLength-2) {
            if (head < 0) {


                if (A[even] % 2 == 0) {
                    even += 2;
                } else {
                    head = even;
                }
            }
            if (tail < 0) {


                if (A[odd] % 2 == 1) {
                    odd += 2;
                } else {
                    tail = odd;
                }
            }

            if (tail != -1 && head != -1) {
                A[tail] = A[tail] + A[head];
                A[head] = A[tail] - A[head];
                A[tail] = A[tail] - A[head];
                tail = -1;
                head = -1;
            }
        }
        return A;

    }
}
