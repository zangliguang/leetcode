package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: [["a"]]
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if(s.length()==1){
            List<String> list=new ArrayList<>();
            list.add(s);
            result.add(list);
            return result;
        }

        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            String endStr = s.substring(i);
            String startStr = s.substring(0, i);

            if(isPalindrom(endStr)){
                for (List<String> strings : partition(startStr)) {
                    strings.add(endStr);
                    result.add(strings);
                }
                if(i==0){
                    List<String> list=new ArrayList<>();
                    list.add(endStr);
                    result.add(list);

                }
            }
        }

        return result;

    }

    private static boolean isPalindrom(String substring) {
        boolean result=true;
        char[] chars = substring.toCharArray();
        for (int i1 = 0; i1 < chars.length/2; i1++) {
            if(chars[i1] != chars[chars.length-i1-1]){
                result=false;
                break;
            }

        }
        return result;
    }
}
