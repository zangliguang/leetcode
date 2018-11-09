package easy;

import java.util.Arrays;

/**
 * num 905
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 1, 4};
        System.out.println(Arrays.toString(sortArrayByParity(array)));
    }


    public static int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        int head = -1, tail = -1;
        while (i < j) {

            if (head < 0) {
                if (A[i] % 2 == 1) {
                    head = i;
                } else {
                    i++;
                }
            }
            if (tail < 0) {
                if (A[j] % 2 == 0) {
                    tail = j;
                } else {
                    j--;
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
