package easy;

import java.util.*;

/**
 * 748 Shortest Completing Word
 */
public class ShortestCompletingWord {

    public static void main(String[] args) {
        String s = shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"});
        System.out.println(s);
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        char[] chars = licensePlate.toLowerCase().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
                set.add(chars[i]);

            }

        }
        int j = 0;
        String temp;
        for (String word : words) {
            int length = word.length();
            j = 0;
            temp = word;
            for (Character character : set) {
                temp = temp.replaceAll(String.valueOf(character), "");
                if (length - temp.length() < map.get(character)) {
                    break;
                }
                length = temp.length();
                j++;
            }
            if (j == set.size()) {
                return word;
            }

        }
        return null;
    }
}
