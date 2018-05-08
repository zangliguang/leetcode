package medium;

/**
 * 55. Jump Game
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int i, reach = 0;
        for (i = 0; i <= reach && i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);
        }
        return i == nums.length;

    }
}
