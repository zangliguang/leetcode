package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1170 Compare Strings by Frequency of the Smallest Character
 */
public class CompareStringsbyFrequencyoftheSmallestCharacter {
    public static void main(String[] args) {
        numSmallerByFrequency(new String[]{"aabbabbb","abbbabaa","aabbbabaa","aabba","abb","a","ba","aa","ba","baabbbaaaa","babaa","bbbbabaa"},new String[]{"b","aaaba","aaaabba","aa","aabaabab","aabbaaabbb","ababb","bbb","aabbbabb","aab","bbaaababba","baaaaa"});
    }
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        int max = 0;
        for (int i = 0; i < queries.length; i++) {
            q[i] = getMinNum(queries[i]);
            max = Math.max(max, q[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            w[i] = getMinNum(words[i]);
            for (int j = 1; j < w[i]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        for (int i = 0; i < q.length; i++) {
            q[i] = map.getOrDefault(q[i],0);
        }
        return q;


    }

    static int getMinNum(String str) {
        char[] a = str.toCharArray();
        Arrays.sort(a);
        int result = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[0]) {
                result++;
            }else{
                break;
            }
        }
        return result;
    }
}
