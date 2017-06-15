package easy;

/**
 * Created by zangliguang on 2017/6/14.Num290
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * <p>
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * <p>
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * <p>
 * Credits:
 * Special thanks to @minglotus6 for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) return false;
            } else {
                if (unique.contains(strs[i])) return false;
                map.put(c, strs[i]);
                unique.add(strs[i]);
            }
        }
        return true;
    }
}
