package easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 怒骂089
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr2=new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(arr2);
    }
    public static void duplicateZeros(int[] arr) {

        int length = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                list.add(0);
                list.add(0);
            } else {
                list.add(arr[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            arr[i] = list.get(i);
        }

        System.out.println(Arrays.toString(arr));
    }
}
