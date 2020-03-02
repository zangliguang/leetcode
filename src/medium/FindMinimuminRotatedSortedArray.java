package medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int start = 0, end = nums.length-1, mid = 0;
        if(nums[0]<nums[end]) return nums[0];
        while(end-start>1)
        {
            mid = start + (end - start)/2;
            if(nums[start]>nums[mid])
                end = mid;
            else
                start = mid;

        }
        return nums[end];
    }

    public int maximum69Number (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
