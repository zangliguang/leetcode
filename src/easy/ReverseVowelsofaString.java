package easy;

/**
 * Created by zangliguang on 2017/7/6.Num345
 */

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int tail = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (isVowels(chars[i])) {
                for (int j = tail; j >= 0; j--) {
                    if (i < j && isVowels(chars[j])) {
                        char tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                        tail = j - 1;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();

    }

    private static boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

}
