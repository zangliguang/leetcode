package easy;


import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("c"));
    }

    public static List<String> letterCasePermutation(String S) {
        ArrayList<String> result = new ArrayList<>();
        if (S.trim().length() == 0) {
            result.add(S);
            return result;
        }
        result.add("");
        char[] chars = S.toCharArray();
        setResult(result, chars, 0);
        return result;

    }

    private static void setResult(ArrayList<String> result, char[] chars, int start) {
        int length = chars.length;
        int end;
        for (end = start; end < length; end++) {

            if (Character.isLetter(chars[end])) {
                end++;
                break;
            }
        }
        String str = new String(chars, start, end - start);
        if (end == length && !Character.isLetter(chars[end - 1])) {
            for (int j = 0; j < result.size(); j++) {
                result.set(j, result.get(j) + str);
            }
            return;
        } else {
            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                String origin = result.get(j);
                result.set(j, origin + str.toLowerCase());
                temp.add(origin + str.toUpperCase());
            }
            result.addAll(temp);
        }


        if (end == length) {
            return;
        }
        setResult(result, chars, end);
    }
}
