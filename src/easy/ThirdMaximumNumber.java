package easy;

import java.util.PriorityQueue;

/**
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (pq.contains(nums[i])) {
                continue;
            }
            pq.add(nums[i]);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        if (pq.size() == 2) {
            pq.poll();
            return pq.poll();
        }
        return pq.peek();
    }
}
