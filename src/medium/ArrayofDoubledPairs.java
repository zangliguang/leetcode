package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * 954. Array of Doubled Pairs
 * <p>
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,3,6]
 * Output: false
 * Example 2:
 * <p>
 * Input: [2,1,2,6]
 * Output: false
 * Example 3:
 * <p>
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 * <p>
 * Input: [1,2,4,16,8,4]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 30000
 * A.length is even
 * -100000 <= A[i] <= 100000
 */
public class ArrayofDoubledPairs {
    public static void main(String[] args) {
        int[]A={4,-2,2,-4};
        System.out.println(canReorderDoubled(A));
    }

    public static boolean canReorderDoubled(int[] A) {
        HashMap<Integer, Integer> map = new HashMap();


        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (map.getOrDefault(A[i], 0) == 0) {
                continue;
            }
            if (A[i] == 0 && map.getOrDefault(A[i], 0) % 2 == 0) {
                map.remove(A[i]);
                continue;
            }else if (A[i] > 0 && map.getOrDefault(A[i], 0) <= map.getOrDefault(2 * A[i], 0)) {
                map.put(2 * A[i], map.getOrDefault(2 * A[i],0) - map.getOrDefault(A[i],0));
                map.remove(A[i]);
            } else if (A[i] < 0 && map.getOrDefault(A[i], 0) <= map.getOrDefault(A[i] / 2, 0)) {
                map.put(A[i] / 2, map.get(A[i] / 2) - map.get(A[i]));
                map.remove(A[i]);
            } else {
                return false;
            }
        }
        return true;


    }
}
