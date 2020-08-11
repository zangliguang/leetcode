package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 720  Longest Word in Dictionary
 */
public class LongestWordinDictionary {

    public static void main(String[] args) {
        String[] arr=new String[]{"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(arr));
    }
    public static  String longestWord(String[] words) {
        var set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (o1, o2) -> {
            if(o1.length()==o2.length()){
                return o2.compareTo(o1);
            }
            return o1.length() - o2.length();
        });
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (isLongWord(set, words[i])) {
                result = words[i];
                break;
            }
        }
        return result;

    }

    private static boolean isLongWord(HashSet<String> set, String word) {
        boolean contain;
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        contain = true;
        for (char a : chars) {
            sb.append(a);
            if (!set.contains(sb.toString())) {
                contain = false;
                break;
            }
        }
        return contain;
    }
}
