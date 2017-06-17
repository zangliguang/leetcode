package easy;

/**
 * Created by zangliguang on 2017/6/13.Num344
 */

import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class ReverseString {

    public static void main(String[] args) {

    }

    public static String reverseString(String s) {
        if (s == null)
            return null;
        StringBuffer buffer = new StringBuffer(s);
        buffer.reverse();
        return buffer.toString();

    }

    public static String reverseString01(String s) {
        if (s == null)
            return null;
        int count = s.length();
        int n = count - 1;
        char[] value = s.toCharArray();
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
        }
        return new String(value);
    }
}
