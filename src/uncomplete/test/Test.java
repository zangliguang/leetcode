package uncomplete.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zangliguang on 2017/7/6.
 */
public class Test {
    public static void main(String[] args) {
        int[] nums=new int[] {1,2,3};
        System.out.println("结果："+divide(25,4));
    }


    public static int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
    }

    // It's easy to handle edge cases when
// operate with long numbers rather than int
    public static long divideLong(long dividend, long divisor) {

        // Remember the sign
        boolean negative = dividend < 0 != divisor < 0;

        // Make dividend and divisor unsign
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;

        // Return if nothing to divide
        if (dividend < divisor) return 0;

        // Sum divisor 2, 4, 8, 16, 32 .... times
        long sum = divisor;
        long divide = 1;
        while ((sum+sum) <= dividend) {
            sum += sum;
            System.out.println("sum："+sum);
            divide += divide;
        }

        System.out.println(divide);
        // Make a recursive call for (devided-sum) and add it to the result
        return negative ? -(divide + divideLong((dividend-sum), divisor)) :
                (divide + divideLong((dividend-sum), divisor));
    }
}
