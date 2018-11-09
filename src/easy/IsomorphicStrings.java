package easy;

import java.util.Arrays;

/**
 * num205
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("ea", "ee"));
    }

    public static boolean isIsomorphic2(String s, String t) {
        int length = s.length();
        if (s.equals(t) || length == 1) {
            return true;
        }

        int m1[] = new int[256];
        int m2[] = new int[256];

        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1[c1] != m2[c2]) {
                return false;
            }
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }
        return true;

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        String c1 = String.valueOf(s.charAt(0));
        String c2 = String.valueOf(t.charAt(0));
        s = s.substring(1, s.length());
        t = t.substring(1, t.length());
        int index = s.indexOf(c1);
        int index2 = t.indexOf(c2);
        int lastindex = s.lastIndexOf(c1);


        if (index != index2) {
            return false;
        }
        while (index == index2 && index > 0) {

            s = s.replaceFirst(c1, "");
            t = t.replaceFirst(c2, "");
            index = s.indexOf(c1);
            index2 = t.indexOf(c2);
        }
        if (index == index2) {
            return isIsomorphic(s, t);
        } else {
            return false;
        }


    }
}
