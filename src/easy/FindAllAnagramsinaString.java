package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsinaString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    /**
     * 超时了
     * @param s
     * @param p
     * @return
     */
//    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> result = new ArrayList<>();
//        char[] a = p.toCharArray();
//        Arrays.sort(a);
//        int totalLength = s.length();
//        int length = p.length();
//        String mark = new String(a);
//
//        for (int i = 0; i < totalLength - length + 1; i++) {
//            char[] chars = s.substring(i, length + i).toCharArray();
//            Arrays.sort(chars);
//            if (new String(chars).equals(mark)) {
//                result.add(i);
//            }
//
//        }
//        return result;
//    }
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null||s.length() == 0||p == null||p.length()==0)
            return result;
        int[] hash = new int[256];
        char[] pp = p.toCharArray();
        for(char i:pp){
            hash[i]++;
        }
        int left = 0, right = 0, count = p.length();
        while(right < s.length())
        {
            if(hash[s.charAt(right++)]-- > 0)  //窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，表示p字符串也包含这个，所以count做减法
                count--;
            if(count == 0)
                result.add(left);//count指示器，为0表示和p对应的hash值完全一致
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
                //如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
                count++;
        }

        return result;
    }


}
