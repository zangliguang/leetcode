package medium;

import java.util.*;

/**
 * 567 Permutation in String
 */
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        for (int i = 0; i < chars2.length-chars1.length+1; i++) {
            char[] charsSplit = Arrays.copyOfRange(chars2, i, i + chars1.length);
            Arrays.sort(charsSplit);
            if (Arrays.equals(chars1, charsSplit)) {
                return true;
            }
        }
        return false;

    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] origin = new int[26];
        int[] splite = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            origin[chars1[i] - 'a']++;
            splite[chars2[i] - 'a']++;
        }
        int length = chars2.length - chars1.length + 1;
        for (int i = 0; i < length; i++) {
            if (Arrays.equals(origin, splite)) {
                return true;
            }
            splite[chars2[i] - 'a']--;
            if (i + chars1.length == chars2.length) {
                return false;
            }
            splite[chars2[i + chars1.length] - 'a']++;
        }
        return false;

    }
}
