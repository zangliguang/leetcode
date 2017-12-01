package Medium;

import java.util.*;

/**
 * num49
 * Given an array of strings, group anagrams together.
 * <p>
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * <p>
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            System.out.println(key);
            List<String> stringList = map.getOrDefault(key, new ArrayList());
            stringList.add(str);
            map.put(key, stringList);
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            result.add((List<String>) entry.getValue());
        }

        return result;
    }
}
