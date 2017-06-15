package easy;

/**
 * Created by zangliguang on 2017/6/14. Num504
 */

/**
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * <p>
 * Input: 100
 * Output: "202"
 * <p>
 * Example 2:
 * <p>
 * Input: -7
 * Output: "-10"
 * <p>
 * Note: The input will be in range of [-1e7, 1e7].
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        String symbol = num < 0 ? "-" : "";
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int tempNum = num;
            sb.insert(0, String.valueOf(num % 7));
            num = num - num % 7;
            num /= 7;
        }
        sb.insert(0, symbol);
        return sb.toString();
    }
}
