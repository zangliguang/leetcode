package Medium;

/**
 * Num647
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * Example 2:
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * Note:
 * <p>
 * The input string length won't exceed 1000.
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        char a = 'a';
        char b = 'a';
        System.out.printf("结果：" + countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int result = 0;
        if (s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                result += isPalindromic(chars, i, j) ? 1 : 0;
            }
        }


        return result;
    }

    private static boolean isPalindromic(char[] chars, int i, int j) {
        if (i == j) {
            return true;
        }
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
