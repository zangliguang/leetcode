package easy;

/**
 * Created by zangliguang on 2017/6/13. Num7
 */

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-12345));
    }

    public static int reverse(int x) {
        long result = 0;
        int symbol = x > 0 ? 1 : -1;
        x = Math.abs(x);
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE) {
            result = 0;
        }
        return (int) result * symbol;
    }
}
