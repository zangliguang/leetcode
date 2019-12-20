package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1122. Relative Sort Array
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap map = new HashMap();
        for (int i1 : arr2) {
            map.put(i1, 0);
        }

        int length = arr1.length;
        int[] result = new int[length];
        int endIndex = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], (Integer) map.get(arr1[i]) + 1);
            } else {
                result[length - endIndex - 1] = arr1[i];
                endIndex++;
            }


        }
        Arrays.sort(result, length - endIndex - 1, length);
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int end = index + (Integer) map.get(arr2[i]);
            Arrays.fill(result, index, end, arr2[i]);
            index = end;
        }

        return result;

    }


}
