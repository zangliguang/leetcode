package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 893 Groups of Special-Equivalent Strings
 */
public class GroupsofSpecialEquivalentStrings {
    public static void main(String[] args) {
        String[] strs=new String[]{"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        System.out.println(numSpecialEquivGroups(strs));
    }

    public static int numSpecialEquivGroups(String[] A) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] even = new char[A[0].length() / 2];
        char[] odd = new char[A[0].length() / 2 + A[0].length() % 2];
        boolean isOdd = A[0].length() % 2 > 0;
        for (String s : A) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                even[i] = chars[i * 2 + 1];
                odd[i] = chars[i * 2];
            }
            if (isOdd) {
                odd[odd.length - 1] = chars[s.length() - 1];
            }
            Arrays.sort(odd);
            Arrays.sort(even);

            String key = new String(odd) +"-"+ new String(even);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map.keySet().size();

    }
}
