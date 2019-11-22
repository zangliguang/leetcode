package easy;

/**
 * 680 Valid Palindrome II
 * <p>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("deeee"));
    }

    static int num = 0;

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                num++;
                return num <= 1 && (validPalindrome(s.substring(i + 1, length - i)) || validPalindrome(s.substring(i, length - i - 1)));
            }
        }
        return true;

    }

}
