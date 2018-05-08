package uncomplete.test;


import java.io.File;
import java.io.IOException;

/**
 * Created by zangliguang on 2017/7/6.
 */
public class Test {
    public static void main(String[] args) {
        File directory = new File("");//参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(courseFile);
        System.out.println(System.getProperty("user.dir"));
        System.out.println( System.getProperty("java.class.path"));
        System.out.println( System.getProperty("java.class.path"));
    }

    private void printPath() {
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
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
