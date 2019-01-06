package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * num39
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * Accepted
 * 282,308
 * Submissions
 * 622,572
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,6,7};
        System.out.println(combinationSum(arr,7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == candidates || candidates.length == 0) return result;
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            setResult(result, new ArrayList<>(), candidates, i, target);
        }

        return result;

    }

    private static void setResult(List<List<Integer>> result, List<Integer> current, int[] candidates, int index, int target) {
        if (index>=candidates.length||candidates[index] > target) {
            return;
        }


        while (target > candidates[index]) {
            current.add(candidates[index]);
            target -= candidates[index];
            for (int i = index + 1; i < candidates.length; i++) {
                setResult(result, current, candidates, i, target);
            }
        }
        if (candidates[index] == target) {
            current.add(candidates[index]);
            result.add(current);
        }


    }
}
