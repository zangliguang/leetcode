package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 90. Subsets II
 */
public class SubsetsII {
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> preResult = new ArrayList<>();
        List<List<Integer>> curentResult = new ArrayList<>();
        result.add(new ArrayList<>());
        preResult.add(new ArrayList<>());
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            for (List<Integer> integers : preResult) {


                    for (Integer integer : set) {
                        List<Integer> temp = integers;
                        temp.add(integer);
                        curentResult.add(temp);
                    }

            }

            result.addAll(curentResult);
            preResult=curentResult;
            curentResult.clear();


        }


        return result;

    }
}
