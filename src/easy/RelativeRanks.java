package easy;

/**
 * Created by zangliguang on 2017/8/15.Num506a\
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * Example 1:
 * <p>
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 */
public class RelativeRanks {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        String[] relativeRanks = findRelativeRanks(nums);
        System.out.println(Arrays.toString(relativeRanks));
    }

    public static String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        if (nums.length == 1) {
            return new String[]{"Gold Medal"};
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return new String[]{"Gold Medal", "Silver Medal"};
            } else {
                return new String[]{"Silver Medal", "Gold Medal"};
            }
        }
        int[] tempInt = nums.clone();
        Arrays.sort(tempInt);
        HashMap<Integer, String> map = new HashMap<>();
        map.put(tempInt[tempInt.length - 1], "Gold Medal");
        map.put(tempInt[tempInt.length - 2], "Silver Medal");
        map.put(tempInt[tempInt.length - 3], "Bronze Medal");
        for (int i = tempInt.length - 4; i >= 0; i--) {
            map.put(tempInt[i], String.valueOf(tempInt.length - i));
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}
