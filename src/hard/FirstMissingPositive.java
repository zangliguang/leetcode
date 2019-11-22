package hard;

/**
 * 41. First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 * <p>
 * Accepted
 * 202,296
 * Submissions
 * 708,609
 * Seen this question in a real interview before?
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int ans = 1; int prev = 0;
        while (prev != ans){
            prev = ans;
            for (int i=0; i<nums.length; i++){
                ans = ans == nums[i] ? nums[i] + 1 : ans;
            }
        }
        return ans;
    }
}
