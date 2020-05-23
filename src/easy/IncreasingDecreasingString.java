package easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 1370 Increasing Decreasing String
 */
public class IncreasingDecreasingString {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
    }

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        return getString(map, false);


    }

    private static String getString(LinkedHashMap<Character, Integer> map, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            sb.append(entry.getKey());
            if ((Integer) entry.getValue() == 1) {
                it.remove();
            } else {
                entry.setValue((Integer) entry.getValue() - 1);
            }
        }

        if (map.size() == 0) {
            if (reverse) {
                return sb.reverse().toString();
            }
            return sb.toString();
        }
        if (reverse) {
            return sb.reverse().append(getString(map, false)).toString();
        } else {
            return sb.append(getString(map, true)).toString();
        }
    }
}
