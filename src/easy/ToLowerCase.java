package easy;

/**
 * num 709
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("ASSDDD"));
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        int gap = 'A' - 'a';
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c >= 'A'&&c <= 'Z') {
                str = str.replace(c, (char) (c - gap));
            }
        }
        return str;

    }
}
