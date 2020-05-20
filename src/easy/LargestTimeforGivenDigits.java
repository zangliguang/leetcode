package easy;

import javafx.beans.property.Property;

import java.util.*;

/**
 * 949. Largest Time for Given Digits
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 * <p>
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 * <p>
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 * <p>
 * Input: [5,5,5,5]
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class LargestTimeforGivenDigits {
    public static void main(String[] args) {

        int[] A1 = new int [] {1,2,3,4};
        System.out.println( largestTimeFromDigits(A1));

    }
    public static String largestTimeFromDigits(int[] A) {


        Arrays.sort(A);
        /**
         * 012
         * 0~9/0-3
         * 0~5
         * 0~9
         *
         * 0
         */
        if (A[0] > 2 || A[1] > 5) {
            return "";
        }
        if (A[0] == 2 || A[1] > 3) {
            return "";
        }

        if (A[3] < 3) { //小于2222
            return A[3] + "" + A[2] + ":" + A[1] + "" + A[0];
        }
        if (A[2] < 2 || (A[2] == 2 && A[3] <= 3)) {
            return A[2] + "" + A[3] + ":" + A[1] + "" + A[0];
        }
        if (A[2] == 2) {

            if (A[3] > 5) {
                return A[2] + "" + A[1] + ":" + A[0] + "" + A[3];
            } else {
                return A[2] + "" + A[1] + ":" + A[3] + "" + A[0];
            }


        }
        int[] A1 = new int[4];
        int[] A2 = new int[3];
        int[] A3 = new int[4];
        int[] A4 = new int[4];
        Arrays.fill(A1, -1);
        Arrays.fill(A2, -1);
        Arrays.fill(A3, -1);
        Arrays.fill(A4, -1);
        ArrayList list = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {

            if (A[i] > 2) {
                continue;
            }

            A1[i] = A[i];

            for (int j = 0; j < A.length && i != j; j++) {

                if (A[i] == 2 && A[j] > 3) {
                    continue;
                }
                A2[j] = A[j];
                for (int k = 0; k < A.length && k != j && k != i; k++) {
                    if (A[k] > 5) {
                        continue;
                    }
                    A3[k] = A[k];
                    for (int l = 0; l < A.length && l != j && l != i && l != k; l++) {
                        A4[l] = A[l];
                        list.add(A1[i] * 1000 + A2[j] * 100 + A3[k] * 10 + A4[l]);
                    }
                }

            }
        }

        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
        Integer result = (Integer) list.get(list.size() - 1);

        return new StringBuilder(result.toString()).insert(2,':').toString();
//        // - - 2 3
//        if (A[2] == 3) {
//
//        }


    }


}
