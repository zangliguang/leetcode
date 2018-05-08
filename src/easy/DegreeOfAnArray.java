package easy;

import java.util.*;

/**
 * 697. Degree of an Array
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        LinkedHashMap<Integer, Integer> head = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> taile = new HashMap<>();
        LinkedHashMap<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
            if (!head.containsKey(nums[i])) {
                head.put(nums[i], i);
                list.add(nums[i]);
            }
            if (!taile.containsKey(nums[length - 1 - i])) {
                taile.put(nums[length - 1 - i], length - i);
            }

        }
        Collections.sort(list, (o1, o2) -> {
            int result = frequencyMap.get(o2) - frequencyMap.get(o1);
            if (result == 0) {
                return taile.get(o1) - head.get(o1) - taile.get(o2) + head.get(o2);
            }
            return result;
        });
        return taile.get(list.get(0)) - head.get(list.get(0));

    }
}
