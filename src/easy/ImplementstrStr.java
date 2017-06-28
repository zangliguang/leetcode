package easy;

/**
 * Created by zangliguang on 2017/6/28. Num28
 */

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != (needle.charAt(j))) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
    }
}
