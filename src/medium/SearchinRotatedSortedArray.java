package medium;

import java.util.Arrays;

/**
 * num33
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        // 二分法思想
        if(nums == null || nums.length == 0){
            return -1;
        }
        // 首先找到旋转数组分界点
        int sep = splitRotateArray(nums);

        int res;
        if(target > nums[nums.length - 1]){ // 在左侧
            res = Arrays.binarySearch(nums, 0, sep, target);
        } else { // 在右侧
            res = Arrays.binarySearch(nums, sep, nums.length, target);
        }
        if(res < 0){
            return -1;
        } else {
            return res;
        }

    }

    public int splitRotateArray(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]){ // 不在旋转数组中
                left = mid + 1;
            } else if(nums[mid] < nums[right]){ // 在旋转数组中
                right = mid;
            }
        }
        return right;
    }
}
