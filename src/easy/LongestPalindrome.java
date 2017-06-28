package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zangliguang on 2017/6/23. Num409
 */

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.

 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
    public static int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        int result=0;
        char[] chars=s.toCharArray();
        Set<Character> set=new HashSet<>();
        for(int i=0;i<chars.length;i++){
            if(set.contains(chars[i])){
                set.remove(chars[i]);
                result+=2;
            }else{
                set.add(chars[i]);
            }
        }
        return result+(set.size()>0?1:0);

    }
}
