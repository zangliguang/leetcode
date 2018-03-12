package uncomplete;

import static java.lang.Math.abs;

/**
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int result = 1;
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        if (!positive) {
            return -divide(Math.abs(dividend), Math.abs(divisor));
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) return 0;
        return result;

    }
}
