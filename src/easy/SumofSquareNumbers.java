package easy;

/**
 * Created by zangliguang on 2017/7/10.Num633
 */

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: False
 */
public class SumofSquareNumbers {
    public static void main(String[] args) {
        int sqrt = 1;
        double sqrt2 = 1.0;
        System.out.println(sqrt == sqrt2);
    }

    public static boolean judgeSquareSum(int c) {
        boolean result = false;
        int max = (int) Math.sqrt(c);
        int min = 0;
        while (max >= min) {
            int calculation = (int) (Math.pow(min, 2) + Math.pow(max, 2));
            if (calculation > c) {
                max--;
            } else if (calculation < c) {
                min++;
            } else {
                return true;
            }
        }
        return result;


    }
}
