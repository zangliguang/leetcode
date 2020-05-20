package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 */
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], (Integer) map.getOrDefault(arr[i], 0) + 1);
        }
        return new HashSet<Integer>(map.values()).size() == map.size();
    }

}
