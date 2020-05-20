package easy;

import java.util.*;

/**
 * num 1365. How Many Numbers Are Smaller Than the Current Number
 */
public class HowManyNumbersAreSmallerThan {

    public static void main(String[] args) {

        smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
        }

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            for (int num : nums) {
                if (num < key) {
                    map.put(key, map.get(key) + 1);
                }
            }


        }
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;


    }
}
