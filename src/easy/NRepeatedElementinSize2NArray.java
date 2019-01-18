package easy;

/**
 * N-Repeated Element in Size 2N Array
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * <p>
 * Return the element repeated N times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * <p>
 * <p>
 * Note:
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 */
public class NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
                return a;
        return -1;

    }

    public int repeatedNTimes2(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }
}
