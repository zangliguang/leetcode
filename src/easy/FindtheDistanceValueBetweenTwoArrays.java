package easy;

import java.util.HashSet;

/**
 * 1385 Find the Distance Value Between Two Arrays
 */
public class FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
            for (int j = 1; j <= d; j++) {
                set.add(arr2[i] - j);
                set.add(arr2[i] + j);
            }
        }
        int result = 0;
        for (int i : arr1) {
            if (!set.contains(i)) {
                result++;
            }
        }
        return result;

    }
}
