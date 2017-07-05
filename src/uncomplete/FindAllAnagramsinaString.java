package uncomplete;

/**
 * Created by zangliguang on 2017/6/29.Num438
 */

import java.util.*;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "a"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int pLength = p.length();
        int sLength = s.length();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < pLength; i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i <= sLength - pLength; i++) {

            String temp = s.substring(i, i + pLength);
            if (p.indexOf(temp.charAt(0)) >= 0) {
                HashMap<Character, Integer> tmpMap = (HashMap<Character, Integer>) map.clone();
                tmpMap.remove(temp.charAt(0));
                for (int j = 1; j < pLength; j++) {
                    if (tmpMap.getOrDefault(temp.charAt(j), 0) <= 1) {
                        tmpMap.remove(temp.charAt(j));
                    } else {
                        tmpMap.put(temp.charAt(j), map.get(temp.charAt(j)) - 1);
                    }

                }
                if (tmpMap.isEmpty()) {
                    list.add(i);
                }
            }
        }
        return list;

    }
}
