package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 */
public class FindWordsThatCanBeFormedbyCharacters {
    public int countCharacters(String[] words, String chars) {

        int result = 0;
        HashMap map = new HashMap<Character, Integer>();
        char[] origin = chars.toCharArray();
        for (char c : origin) {
            map.put(c, (Integer) map.getOrDefault(c, 0) + 1);
        }
        boolean formed = true;
        HashMap map2 = new HashMap<Character, Integer>();
        for (String word : words) {
            char[] w = word.toCharArray();

            for (char c : w) {
                int value = (Integer) map2.getOrDefault(c, 0) + 1;
                if (value > (Integer) map.getOrDefault(c, 0)) {
                    formed = false;
                }
                map2.put(c, value);
            }
            map2.clear();
            if (formed) {
                result += w.length;
            } else {
                formed = true;
            }

        }
        return result;

    }

    public static int countCharacters2(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
        //Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
        // Comparing each word in words
        for (String word : words) {
            // simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length);
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(buddyStrings("abcaa",
                "abcbb"));
    }

    public static boolean buddyStrings(String A, String B) {
        char[] charsA = A.toCharArray();
        if (A.equals(B)) {
            HashSet set = new HashSet();
            for (Character c : charsA) {
                set.add(c);
            }
            return set.size() != A.length();
        }
        if (A.length() != B.length()) {
            return false;
        }

        Character a1 = null;
        Character b1 = null;
        char[] charsB = B.toCharArray();
        int num = 0;
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                if (a1 == null) {
                    a1 = charsA[i];
                    b1 = charsB[i];

                } else {
                    if (charsA[i] != b1 || charsB[i] != a1) {

                        return false;
                    }
                }
                num++;
                if (num > 2) {
                    return false;
                }
            }

        }
        return num == 2;

    }
}
