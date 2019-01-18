package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * num830 Positions of Large Groups
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * <p>
 * Note:  1 <= S.length <= 1000
 */
public class PositionsofLargeGroups {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abc"));
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        Character a = chars[0];
        int start = 0;
        int end = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != a) {
                a = chars[i];
                end = i - 1;
                if (end != start) {
                    setResult(result, start, end);

                }
                start = i;
            }
        }
        if (a == chars[chars.length - 1] && start != chars.length - 1) {
            setResult(result, start, chars.length - 1);
        }
        return result;
    }

    private static void setResult(List<List<Integer>> result, int start, int end) {
       if(end - start<2){
           return;
       }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        result.add(list);
    }
}
