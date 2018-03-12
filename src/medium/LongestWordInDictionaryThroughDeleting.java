package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 524. Longest Word in Dictionary through Deleting
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * <p>
 * Output:
 * "apple"
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * <p>
 * Output:
 * "a"
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        System.out.println(findLongestWord("bab", d));
    }

    public static String findLongestWord(String s, List<String> d) {
        if (s.length() == 0 || d.size() == 0) return "";

        Collections.sort(d, (a, b) -> {
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        for (int i = 0; i < d.size(); i++) {
            char[] chars = d.get(i).toCharArray();
            int j, preIndex = 0;
            for (j = 0; j < chars.length; j++) {
                preIndex = s.indexOf(chars[j], preIndex);
                if (preIndex < j) {
                    break;
                }
                preIndex++;
            }
            if (j == chars.length) {
                return d.get(i);
            }

        }
        return "";
    }
}
