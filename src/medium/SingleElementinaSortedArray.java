package medium;

/**
 * Created by zangliguang on 2017/7/31.Num540
 */

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Integer result;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i += 2;
        }
        return nums[i];
    }
}
