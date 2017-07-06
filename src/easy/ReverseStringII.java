package easy;

/**
 * Created by zangliguang on 2017/7/6.Num541
 */


/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * <p>
 * Example:
 * <p>
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * <p>
 * Restrictions:
 * <p>
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        int num = s.length() / (2 * k);
        String result = "";
        for (int i = 0; i < num + 1; i++) {

            int endIndex = i * 2 * k + k;
            if (endIndex < s.length()) {
                String substring = s.substring(i * 2 * k, endIndex);
                result += getReverseStr(substring);
                result += s.substring(endIndex, Math.min(s.length(), i * 2 * k + 2 * k));
            } else {
                String substring = s.substring(i * 2 * k, s.length());
                result += getReverseStr(substring);
            }

        }


        return result;
    }

    private static String getReverseStr(String substring) {
        String result = "";
        char[] chars = substring.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result = chars[i] + result;
        }
        return result;
    }
}
