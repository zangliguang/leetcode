package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438 Find All Anagrams in a String
 */
public class FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        char[] chars1 = p.toCharArray();
        char[] chars2 = s.toCharArray();
        int[] origin = new int[26];
        int[] splite = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            origin[chars1[i] - 'a']++;
            splite[chars2[i] - 'a']++;
        }

        int length = chars2.length - chars1.length + 1;
        for (int i = 0; i < length; i++) {
            if (Arrays.equals(origin, splite)) {
                res.add(i);
            }
            splite[chars2[i] - 'a']--;
            if (i + chars1.length == chars2.length) {
                return res;
            }
            splite[chars2[i + chars1.length] - 'a']++;
        }
        return res;
    }
}
