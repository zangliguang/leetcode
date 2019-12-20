package medium;

import java.util.*;

/**
 * 1282. Group the People Given the Group Size They Belong To
 * There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.
 * <p>
 * You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5],[0,1,2],[3,4,6]]
 * Explanation:
 * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
 * Example 2:
 * <p>
 * Input: groupSizes = [2,1,3,3,3,2]
 * Output: [[1],[0,5],[2,3,4]]
 */
public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(arr));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();

        HashMap map = new HashMap<Integer, String>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.put(groupSizes[i], (String) map.getOrDefault(groupSizes[i], "") + i + ",");

        }

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String[] split = ((String) entry.getValue()).split(",");
            System.out.println(Arrays.toString(split));
            ArrayList list = new ArrayList<Integer>();
            for (String s : split) {
                list.add(Integer.valueOf(s));
                if (list.size() == (Integer) entry.getKey()) {
                    result.add((List<Integer>) list.clone());
                    list.clear();
                }
            }


        }
        return result;

    }

}
