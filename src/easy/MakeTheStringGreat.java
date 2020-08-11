package easy;

/**
 * 1544. Make The String Great
 */
public class MakeTheStringGreat {
    public String makeGood(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1] && Character.toLowerCase(chars[i]) == Character.toLowerCase(chars[i + 1])) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;

    }
}
