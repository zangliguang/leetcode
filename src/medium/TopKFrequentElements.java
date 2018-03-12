package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Num347
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        topKFrequent(nums, 2);
    }


    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        TreeMap<Integer, ArrayList> tree = new TreeMap<>();
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (!tree.containsKey(value)) {

                tree.put(value, new ArrayList<Integer>());
            }
            tree.get(value).add(key);
//            tree.put(value,tree.get(value));
        }
        while (result.size() < k) {
            result.addAll(tree.pollLastEntry().getValue());
        }
        return result;
    }
}
