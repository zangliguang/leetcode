package Medium;

/**
 * Created by zangliguang on 2017/7/13.Num462
 */

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int end = nums.length - 1;
        int head = 0;
        int resutl = 0;
        while (head < end) {
            resutl = nums[end] - nums[head];
            end--;
            head++;
        }
        return resutl;
    }
}
