package easy;

/**
 * Created by zangliguang on 2017/6/13. Num167
 */

import java.util.HashMap;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class TwoSumIIInputarrayissorted {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 4};
        int target = 6;
        System.out.println(twoSum(numbers, target));
    }


    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            Integer secondIndex = map.getOrDefault(target - numbers[i], -1);
            if (secondIndex >= 0) {
                result[0] = map.getOrDefault((target - numbers[i]), -1) + 1;
                result[1] = i + 1;
                return result;
            } else {
                map.put(numbers[i], i);
            }


        }
        return null;

    }
}