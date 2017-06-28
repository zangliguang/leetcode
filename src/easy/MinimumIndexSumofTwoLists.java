package easy;

/**
 * Created by zangliguang on 2017/6/23.Num599
 */

import java.util.HashMap;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 * <p>
 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * <p>
 * Note:
 * <p>
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class MinimumIndexSumofTwoLists {
    public static void main(String[] args) {
        String s="";
        s.toCharArray();
    }
    public String[] findRestaurant(String[] list1, String[] list2) {

        int minNum = list1.length + list2.length - 2;
        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int num = i + map.get(list2[i]);
                if (num < minNum) {
                    minNum = num;
                    result = new StringBuilder();
                    result.append(list2[i]);
                    result.append(",");

                } else if (num == minNum) {
                    result.append(list2[i]);
                    result.append(",");

                }
            }
        }

        return result.toString().split(",");
    }
}
