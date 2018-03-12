package medium;

/**
 * Created by zangliguang on 2017/7/31.Num565
 */

import java.util.HashSet;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].
 * <p>
 * Sets S[K] for 0 <= K < N are defined as follows:
 * <p>
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
 * <p>
 * Sets S[K] are finite for each K and should NOT contain duplicates.
 * <p>
 * Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * <p>
 * Note:
 * <p>
 * N is an integer within the range [1, 20,000].
 * The elements of A are all distinct.
 * Each element of array A is an integer within the range [0, N-1].
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> allSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            allSet.add(i);
        }
        int result = 0;
        while (!allSet.isEmpty()) {
            int num = allSet.iterator().next();
            while (!set.contains(num)) {
                set.add(num);
                allSet.remove(num);
                num = nums[num];
            }
            if (set.size() > result) {
                result = set.size();
            }
            set.clear();
        }

        return result;
    }
}
