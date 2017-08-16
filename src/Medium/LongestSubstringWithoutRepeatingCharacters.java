package Medium;
/**
 * Created by zangliguang on 2017/6/11.
 */


import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ac"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int head = 0;
        int foot = 0;
        while (foot < s.length()) {
            Integer position = map.getOrDefault(s.charAt(foot), -1);
            if (position < head) {
                map.put(s.charAt(foot), foot);
                max = Math.max(max, foot - head + 1);
                foot++;
            } else {
                map.put(s.charAt(foot), foot);
                head = position + 1;
                foot++;
            }

        }
        return max;
    }
}
