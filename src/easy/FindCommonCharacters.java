package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * num1002. Find Common Characters
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * <p>
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
public class FindCommonCharacters {

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        System.out.println(Arrays.toString(commonChars(A).toArray()));
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        List<Integer[]> integer = new ArrayList<>();
        for (String str : A) {
            Integer[] num = new Integer[26];
            Arrays.fill(num, 0);
            char[] chars = str.toCharArray();
            for (char c : chars) {
                num[c - 'a'] += 1;
            }
            integer.add(num);
        }

        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer[] integers : integer) {
                if (integers[i] == 0) {
                    min = 0;
                    break;
                } else {
                    min = Math.min(min, integers[i]);
                }
            }
            for (int j = 0; j < min; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }

        return result;

    }

    public static List<String> commonChars2(String[] A) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
        }
        char[] a = sb.toString().toCharArray();
        Arrays.sort(a);
        Character c = 'A';
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            if (c != a[i]) {
                if (num >= A.length) {
                    result.add(c.toString());

                }
                c = a[i];
                num = 1;

            } else {
                num++;
            }
        }
        return result;

    }

}
