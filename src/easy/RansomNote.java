package easy;

/**
 * Created by zangliguang on 2017/7/6.Num383
 */

import java.util.*;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.contains(ransomNote)) {
            return true;
        }
        HashMap<Character, Integer> map1 = new HashMap();
        HashMap<Character, Integer> map2 = new HashMap();
        char[] chars = ransomNote.toCharArray();
        char[] chars2 = magazine.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map1.put(chars[i], map1.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 0; i < chars2.length; i++) {
            map2.put(chars2[i], map2.getOrDefault(chars2[i], 0) + 1);
        }
        Iterator iter = map1.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (map2.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;

    }
}
