package easy;

import java.util.Arrays;

/**
 * num 14
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"c", "c"});
        longestCommonPrefix(new String[]{"", "b"});
        longestCommonPrefix(new String[]{"aa", "ab"});
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();
            int length = Math.min(a.length, b.length);
            for (int i = 0; i < length && b[i] == a[i]; i++) {
                prefix.append(b[i]);
            }
        }
        return prefix.toString();
    }


}
