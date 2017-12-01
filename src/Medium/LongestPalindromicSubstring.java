package Medium;

/**
 * num5
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    int low = 0, maxLength = 0;

    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }

        return s.substring(low, low + maxLength);
    }

    private  void extendPalindrome(String s, int i, int j) {
        int length = s.length();
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;

        }
        if (maxLength < (j - i - 1)) {
            maxLength = j - i - 1;
            low = i + 1;
        }
    }
}
