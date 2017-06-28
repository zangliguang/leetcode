package easy;

/**
 * Created by zangliguang on 2017/6/23. Num88
 */

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1=new int[]{0};
        int[] nums2=new int[]{1};
        merge(nums1,0,nums2,1);
        System.out.println(nums1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int endIndex = m + n - 1;
        for (int i = endIndex; i >= 0; i--) {
            if(m==0&&n>0){
                nums1[i] = nums2[n - 1];
                n--;
                continue;
            }
            if(m>0&&n==0){
                nums1[i] = nums1[m - 1];
                m--;
                continue;
            }
            if(m==0&&n==0){
                return;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        }
    }

    private void exchangeNum(int a, int b) {
        a += b;
        b = a - b;
        a -= b;
    }
}
