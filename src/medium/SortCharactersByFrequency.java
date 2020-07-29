package medium;

import java.util.*;

/**
 * 451. Sort Characters By Frequency
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Character[] arr = map.keySet().toArray(new Character[0]);
        Arrays.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2)-map.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            char node = arr[i];

            Integer num = map.get(node);
            for (Integer integer = 0; integer < num; integer++) {
                sb.append(node);
            }

        }
        return sb.toString();

    }
}
