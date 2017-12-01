package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * num151
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * <p>
 * click to show clarification.
 */
public class ReverseWordsinaString {
    public static void main(String[] args) {
        System.out.println(reverseWords("Given an input string, reverse the string word by word."));
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

    }
}
