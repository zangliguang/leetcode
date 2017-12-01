package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * num4
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * <p>
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2};
        int[] nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int two = length / 2;
        int one = two;
        if (length % 2 == 0) {
            one = two - 1;
        }
        int first = 0;
        int second = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() <= two) {
            if (second >= length2 || (first < length1 && nums1[first] < nums2[second])) {
                list.add(nums1[first]);
                first++;
            } else {
                list.add(nums2[second]);
                second++;
            }
        }
        return ((double) list.get(two) + (double) list.get(one)) / 2;


    }
}
